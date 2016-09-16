package com.example.listviewwithcheckboxes;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		android.widget.CompoundButton.OnCheckedChangeListener {

	//Declaraciones
	ListView lv;
	ArrayList<Planet> planetList;
	PlanetAdapter plAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lv = (ListView) findViewById(R.id.listview);
		displayPlanetList();
	}

	private void displayPlanetList() {

		planetList = new ArrayList<Planet>();
		planetList.add(new Planet("Fideos Di Maria", "Especial para arrugar en los momentos claves"));
		planetList.add(new Planet("Hector, el Constructor", "Trabajador multifacetico de Angular. Corta, pica, rebana y hace papasfritas." +
				" Si llama dentro de los próximos minutos" +
				" vendrá con una silla y mesa de regalo. Si se atrasa con un tornillo debes ayudarle. "));
		planetList.add(new Planet("Chevrolet Aveo 2010 LT", "Con llantas, aire acondicionado y doble airbag. Sistema de frenos ABS" +
				" con detalles menores en las puertas por piquetes de mall"));
		planetList.add(new Planet("Iván Vodanovic, the Lawyer", "Reconocido abogado del buffet Phoenix Right te dirá... Objection!"));
		planetList.add(new Planet("Libro de Rol. Werewolf; The Apocalypse 2d edition Deluxe", "El apocalipsis ha llegado " +
				"bajo la luna de sangre del Wyrm "));
		planetList.add(new Planet("CocaCola", "300cc Edición navideña con nombres"));
		planetList.add(new Planet("Angular. Alonso de Cordoba Six Six Six the number of " +
				"the beast", "Sin lactosa. Alto en proteinas y con vitaminas A, B y C. No contiene gluten y con 0% de materia grasa"));

		plAdapter = new PlanetAdapter(planetList, this);
		lv.setAdapter(plAdapter);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		//Toast variable dependiendo del checkbutton selecionado. Muestra su text principal
		int pos = lv.getPositionForView(buttonView);
		if (pos != ListView.INVALID_POSITION) {
			Planet p = planetList.get(pos);
			p.setSelected(isChecked);
			Toast.makeText(
					this,
					"Product selected: " + p.getName() + ". State: is "
							+ isChecked, Toast.LENGTH_SHORT).show();
		}
	}
}
