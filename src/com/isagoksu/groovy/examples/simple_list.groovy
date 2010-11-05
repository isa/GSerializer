package com.isagoksu.groovy.examples

import com.isagoksu.groovy.GSerializer


class Address {
	String street
	String city
}

class Account {
	int id
	String customerName
	int locationId
	List<Address> addresses
}

output = new GSerializer().serialize(
	new Account(
		id:1, 
		customerName:"Jane Doe", 
		locationId:4321,
		addresses: [
			new Address(street: "Nowhere", city: "Istanbul"),
			new Address(street: "In the middle of nowhere", city: "Ankara")
		]
	)
)

assert output == '''
<Account>
  <addresses>
    <Address>
      <street>Nowhere</street>
      <city>Istanbul</city>
    </Address>
    <Address>
      <street>In the middle of nowhere</street>
      <city>Ankara</city>
    </Address>
  </addresses>
  <locationId>4321</locationId>
  <id>1</id>
  <customerName>Jane Doe</customerName>
</Account>
'''.trim()