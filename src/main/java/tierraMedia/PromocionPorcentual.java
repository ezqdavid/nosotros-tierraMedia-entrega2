package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private double descuento;
	private String nombre = "PORCENTUAL";

	public PromocionPorcentual(double descuento, List<Atraccion> atracciones) {
		super(atracciones);
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		Double descuentoInt = this.descuento;
		String frase2 = String.format("%1$" + 2 + "s", descuentoInt.toString());

		return "\n Promo \"" + this.nombre + "\"  << Precio Promocional " + frase2 + " monedas (" + descuentoInt
				+ "% de descuento)  >>   Incluye  " + atraccionesEnPromo;
	}

	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.descuento = descuento;
	}

	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2, Atraccion a3) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.atraccionesEnPromo.add(a3);
		this.descuento = descuento;
	}

	public double getCostoDeVisita() {
		double costo = 0;
		for (Atraccion atraccion : atraccionesEnPromo) {
			costo += atraccion.getCostoDeVisita();
		}
		return costo - (costo * (descuento / 100));
	}

	@Override
	public boolean contiene(Producto p) {
		return false;
	}

}
