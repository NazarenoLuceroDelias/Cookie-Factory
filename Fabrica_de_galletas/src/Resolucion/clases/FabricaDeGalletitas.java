package Resolucion.clases;

import java.util.ArrayList;

public class FabricaDeGalletitas {

	private static final int TANDA = 10000;
	private static final int GRAMOS_TOTALES = 500;
	private ArrayList<Galletita> galletitasFabricadas;
	private ArrayList<Bolsa> bolsas;

	public FabricaDeGalletitas() {
		galletitasFabricadas = new ArrayList<>();
		bolsas = new ArrayList<>();
		fabricarGalletitas();
	}

	private void fabricarGalletitas() {
		for (int g = 0; g < TANDA; g++) {
			galletitasFabricadas.add(new Galletita());
		}
	}

	public void envasar() {
		double grDescartado = 0;
		Galletita galletita;
		Bolsa bolsa = new Bolsa(GRAMOS_TOTALES);
		while (!galletitasFabricadas.isEmpty()) {
			galletita = galletitasFabricadas.remove(0);
			if (galletita.getCalidad() == Calidad.DESCARTE) {
				grDescartado += galletita.getGramos();
			} else {
				embolsar(bolsa, galletita);
				if (bolsa.estaLlena()) {
					estivar(bolsa);
					bolsa = new Bolsa(GRAMOS_TOTALES);
				}
			}
		}
		while (!bolsa.estaVacia()) {
			grDescartado += bolsa.extraer().getGramos();
		}
		informarResultados(grDescartado);
	}

	private void estivar(Bolsa bolsa) {
		bolsas.add(bolsa);
	}

	private void embolsar(Bolsa bolsa, Galletita galletita) {
		bolsa.agregar(galletita);
	}

	public void informarResultados(double grDescartado) {
		System.out.println("Total Bolsas: " + bolsas.size());
		System.out.printf("Peso promedio real Galletitas x Bolsa: %6.2f0\n", obtenerPesoRealPromedio());
		System.out.printf("Kilos de descarte: %5.2f", grDescartado / 1000);
	}

	private double obtenerPesoRealPromedio() {
		double pesoTotal = 0;
		for (Bolsa bolsa : bolsas) {
			pesoTotal += bolsa.getPesoNeto();
		}
		return pesoTotal / bolsas.size();
	}

}
