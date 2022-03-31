package examen.clases;

public class Galletita {
	private static final double GRAMOS_DESEADOS = 10;
	private static final double GRAMOS_ACEPTABLES = GRAMOS_DESEADOS / 2;
	private static final double PORC_COBERTURA_VALIDO = 98;
	private double gramos;
	private boolean entera;
	private double porcentajeCobertura;
	private Calidad calidad;
	
	public Galletita() {
		obtenerEntereza();
		calcularCobertura();
		evaluarCalidad();
	}

	private void calcularCobertura() {
		porcentajeCobertura = Math.min(100, 60 + Math.random() * 50);
	}

	public boolean estaEntera() {
		return entera;
	}

	private void evaluarCalidad() {
		calidad = Calidad.DESEADA;
		if (!entera || porcentajeCobertura < PORC_COBERTURA_VALIDO)
			if (gramos >= GRAMOS_ACEPTABLES)
				calidad = Calidad.ACEPTABLE;
			else
				calidad = Calidad.DESCARTE;
	}

	public Calidad getCalidad() {
		return calidad;
	}

	public double getGramos() {
		return gramos;
	}

	private void obtenerEntereza() {
		entera = Math.random() > .2;
		if (entera)
			gramos = GRAMOS_DESEADOS;
		else
			gramos = Math.random() * GRAMOS_DESEADOS;
	}

	@Override
	public String toString() {
		return "Galletita [gramos=" + gramos + ", entera=" + entera + ", calidad=" + calidad + "]";
	}

}