package com.isagoksu.groovy.examples

import com.isagoksu.groovy.GSerializer

class Account {
	int id
	String customerName
	int locationId
}

output = new GSerializer().serialize(new Account(
		id: 1, 
		customerName: "Jane Doe", 
		locationId: 4321
	)
)

assert output == '''
<Account>
  <locationId>4321</locationId>
  <id>1</id>
  <customerName>Jane Doe</customerName>
</Account>
'''.trim()