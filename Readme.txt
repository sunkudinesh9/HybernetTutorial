Natural and Saragoate key:
	Natural key - If the column in the table should be unique and not null for the business resion then will that as primary key then this called as natural key
		Ex: Loginid etc....,
	Sarogate Kye - If the column should act as primary key but in feature may change then that time will call that as sarogate key
		Ex: UseID etc...,

@GeneratedValue - it will auto generate the values to primary key based on the primary key datatype.



@Embeddable - if we want to add the another object value in to the existing object then we use this anotation. 
In the Hibernate we have 2 types of objects 
	1. Entity Object 
	2. value Object
	
	Entity Object - It is like the value of the object can identify uniquely 
		Ex: Projectname email address etc..,
	Value Object - it is like the value of the object can dendepnds on the another value to identify
		Ex; Address value which depends on the person id (or) Person name.
	@EnbeddeId - if we want to make the object value as a primay key then we use this anotation.
		
	@AttributeOverride - It is used to change the column name of the embded table 
		Ex: 
			@Embedded
		@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_ADDRESS_STREET")),
				@AttributeOverride(name = "city", column = @Column(name = "HOME_ADDRESS_CITY")),
				@AttributeOverride(name = "state", column = @Column(name = "HOME_ADDRESS_STATE")),
				@AttributeOverride(name = "pinCode", column = @Column(name = "HOME_ADDRESS_PINCODE")) })
		private Address homeAdress;
		@Embedded
		@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "OFFICE_ADDRESS_STREET")),
				@AttributeOverride(name = "city", column = @Column(name = "OFFICE_ADDRESS_CITY")),
				@AttributeOverride(name = "state", column = @Column(name = "OFFICE_ADDRESS_STATE")),
				@AttributeOverride(name = "pinCode", column = @Column(name = "OFFICE_ADDRESS_PINCODE")) })
				





@ElementCollection  - > if we wan to store the collect of object in the table we should use this annotation it will automatically create table with manin table name and embedded tabe name
	Ex: @ElementCollection
	private Set<Address> address = new HashSet<Address>();
	
	emp.getAddress().add(homeAddress);      // home and office address are the objects passing to set.
	emp.getAddress().add(officeAddress);

	@JoinTable(name = '') - if want to customize the name of the collection table we should use this.
	@JoinColumns - if want to rename the columns of the collection table we use this
	@JoinColumn - to rename the perticular column
	 Ex: @JoinTable(name = "user_address")
		@JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "EmployeTable_id") })
		private Set<Address> address = new HashSet<Address>(); 
		
	@CollectionId - which is used to make the column as a primary key it has a below atributes
		@Column(name = "name of the column") - this attribute is use to give the name of the column
		@Type(type = "long") - this is use to give the data type of the column
	note: this is primary key so we have to auto generate the values so we use the below concept
	@GenericGeneratot - it is used to generate the values to the primary key of collection. it has a below attributes
		name = "name of generator", strategy = "increment"
		
	Ex: 
	@JoinTable(name = "user_address")
	@JoinColumns({ @JoinColumn(name = "USER_ID") })
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "increment-gen", type = @Type(type = "long"))
	private Collection<Address> address = new ArrayList<Address>();
	
	
	
	
Fetch Conecps: we have 2 types of fetch 
	1. Lazy - it  is a default behaviour - it is like if we are fetching a one cell value from the collection table it will create one proxy class their the whole list of values will come from that the value will fetch. 
	2. Egarly - directely it will fetch all the values from the collection.
	Ex: @ElementCollection(fetch = FetchType.EAGER)
	
	

One to One mapping - it is used to create the forgen key relactionship which can refer the only one in the forgen key table.
	@OneToOne - it have below attributes 
				
One to Many mapping - it will map the one value in primary key with many values in another table forgenkey
	@OneToMany - it has below attributes 
		@JoinTable(name = "user_vehical", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICAL_ID"))
		
@NotFound(action=NotFoundAction.IGNORE) - if data is not found at any place insted of showing exception it will ignore that 
		and the above anotation is from hibernate.
		
		
Hibernet will also support below collections:
	1. Bags semantic - 	List/ArrayList
	2. Bag segmentwith ID - List/ArrayList
	3. set segment - set
	4. List segment - list
	5. Map segment - map
	
	

Cascade - It is like f u  have any relation like one to many ..... 
			for example if one owner has many cars so while saving the data you have to save the of user and every car insted of that we use cascade
			Ex: 
			@OneToMany(cascade = CascadeType.ALL)
			private Collection<Vehical> vehical = new ArrayList<Vehical>();
	
			Vehical vehical = new Vehical();
			vehical.setVehicalName("car");
	
			Vehical vehical2 = new Vehical();
			vehical2.setVehicalName("Jeep");
	
			emp = new EmployeTable();
			emp.setSalary(2000000);
			emp.getVehical().add(vehical);
			emp.getVehical().add(vehical2);
			with out saving the vehical to the table we are telling the cascad to save.
			session.save(emp);
			tx.commit();
			
Inheritance - in herberneet will have gud benfites if one class inherit the any number of class that all object will save in one table insted of many tables
		@Entity 
		Vehical
		TwoWhiler.setvehicalName("Bike");
		FourWheeler.setvehicalName("car");
		session.save(vehical);
		
		@Entity
		TwoWhiler extends Vehical
			vehicalName;
		@Entity
		FourWheeler extends Vehical
			VehicalName;