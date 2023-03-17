class Driver 
{
   public static void main(String[] args) 
   {
      Person[] family= new Person[10];

      // initialize the array to contain 10 people
      for(int i=0;i<family.length;i++){
		  family[i]=new Person();
	  }
      
      
      // make sure that all people start with age 10
      for (int j=0; j<family.length; j++) {
         if (family[j].age() != 10) 
         {
            System.err.println("person " + j + " is not 10 years old!");
         }
      }
   }
}
