package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GarageRecorder implements Serializable{
	
	private Garage garage;
	
	public void saveGarage(Garage garage){
		this.garage = garage;
		
		try {
			File fileOne = new File("garage");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(garage);
			oos.flush();
			oos.close();
			fos.close();
			
		} catch (Exception e) {
		}

	}
	public Garage loadGarage() {

		try {
			File toRead = new File("garage");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			this.garage = (Garage) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
		}
		return garage;

	}
}
