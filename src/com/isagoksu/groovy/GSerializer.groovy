package com.isagoksu.groovy

class GSerializer {
	def serialize(Object obj) {
		def walkthrough = { walkthrough, child ->
			child.getProperties().findAll { property ->
				(property.key != "class" && property.key != "metaClass")
			}.each { property ->
				if (property.value instanceof Collection) {
					"${property.key}" {
						property.value.each { item ->
							"${item.class.name.tokenize('.').last()}" {
								walkthrough walkthrough, item
							}
						}
					}
				} else if (!property.value.class.package.name.startsWith("java")) {
					"${property.value.class.name.tokenize('.').last()}" {
						walkthrough walkthrough, property.value
					}
				} else {
					"${property.key}" (property.value)
				}
			}
		}

		def string_writer = new StringWriter()
		def builder = new groovy.xml.MarkupBuilder(string_writer)
		walkthrough.delegate = builder
		walkthrough.resolveStrategy = Closure.DELEGATE_FIRST
		
		builder."${obj.class.name.tokenize('.').last()}" {
			walkthrough walkthrough, obj
		}
		
		return string_writer.toString()
	}
}
