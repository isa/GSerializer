package com.isagoksu.groovy.examples

import com.isagoksu.groovy.GSerializer


class Account {
	int id
	Map offers
}

output = new GSerializer().serialize(
	new Account(
		id:1, 
		offers:["Internet":"High Speed", "Phone":"Digital Phone"]
	)
)

assert output == '''
<Account>
  <offers Internet='High Speed' Phone='Digital Phone' />
  <id>1</id>
</Account>
'''.trim()