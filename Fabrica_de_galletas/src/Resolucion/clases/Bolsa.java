package examen.clases;

import java.util.ArrayList;

public class Bolsa {
	private double pesoEstimado;
	private double pesoNeto;
	private ArrayList<Galletita> galletitas;

	public Bolsa(int pesoEstimado) {
		this.pesoEstimado = pesoEstimado;
		this.pesoNeto = 0;
		galletitas = new ArrayList<>();
	}

	public boolean estaLlena() {
		return pesoNeto >= pesoEstimado;
	}

	public void agregar(Galletita galletita) {
		galletitas.add(galletita);
		pesoNeto += galletita.getGramos();
	}

	public boolean estaVacia() {
		return galletitas.isEmpty();
	}

	public Galletita extraer() {
		Galletita galletita = galletitas.remove(0);
		pesoNeto += galletita.getGramos();
		return galletita;
	}

	public double getPesoNeto() {
		return pesoNeto;
	}

}