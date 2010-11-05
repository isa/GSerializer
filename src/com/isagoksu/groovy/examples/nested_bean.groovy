package com.isagoksu.groovy.examples

import com.isagoksu.groovy.GSerializer

class Address {
	String street
	String city
}

class Contact {
	int id
	List<Address> addresses
}

class Account {
	int id
	Contact contact
}

output = new GSerializer().serialize(
	new Account(
		id:1, 
		contact:new Contact(
			id: 345,
			addresses: [
				new Address(street: "Nowhere", city: "Istanbul"),
				new Address(street: "In the middle of nowhere", city: "Ankara")
			]
		)
	)
)

assert output == '''
<Account>
  <id>1</id>
  <Contact>
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
    <id>345</id>
  </Contact>
</Account>
'''.trim()