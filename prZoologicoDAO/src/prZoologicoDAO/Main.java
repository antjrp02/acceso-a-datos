package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		/**Animal a =new Animal("Ardilla","Bosque",0.1);
		AnimalDAO.insertarAnimal(a);
		
		AnimalDAO.deleteAnimal();
		*/
		
		Animal a1 = AnimalDAO.findById(2);
		System.out.println(a1);
	}

}
