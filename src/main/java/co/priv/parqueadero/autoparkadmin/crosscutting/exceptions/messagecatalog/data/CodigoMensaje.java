package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper.concatenate;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper.UNDERLINE;

public enum CodigoMensaje {
	
	M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
	M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
	M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
	M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
	M00005(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00005", true),
	M00006(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00006", true),
	M00007(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00007", true),
	M00008(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00008", true),
	M00009(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00009", true),
	M00010(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00010", true),
	M00011(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00011", true),
	M00012(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00012", true),
	M00013(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00013", true),
	M00014(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00014", true),
	M00015(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00015", true),
	M00016(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00016", true),
	M00017(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00017", true),
	M00018(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00018", true),
	M00019(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00019", true),
	M00020(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00020", true),
	M00021(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00021", true),
	M00022(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00022", true),
	M00023(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000023", true),
	M00024(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00024", true),
	M00025(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00025", true),
	M00026(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00026", true),
	M00027(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00027", true),
	M00028(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00028", true),
	M00029(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00029", true),
	M00030(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00030", true),
	M00032(TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA, "00032", true),
	M00046(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00046", true),
	M00033(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00033", true),
	M00034(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00034", true),
	M00035(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00035", true),
	M00036(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00036", true),
	M00037(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00037", true),
	M00038(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00038", true),
	M00039(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00039", true),
	M00040(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00040", true),
	M00041(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00041", true),
	M00042(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00042", true),
	M00043(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00043", true),
	M00044(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00044", true),
	M00045(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00045", true),
	M00047(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00047", true),
	M00048(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00048", true),
	M00049(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00049", true),
	M00050(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00050", true),


	M00051(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00051", true),
	M00052(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00052", true),



	M00053(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00053", true),
	M00054(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00054", true),
	M00055(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00055", true),
	M00056(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00056", true),
	M00057(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00057", true),
	M00058(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00058", true),
	M00059(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00059", true),
	M00060(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00060", true),
	M00061(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00061", true),
	M00062(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00062", true),
	M00063(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00063", true),
	M00064(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00064", true),
	M00065(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00065", true),
	M00066(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00066", true),
	M00067(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00067", true),
	M00068(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00068", true),
	M00069(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00069", true),
	M00070(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00070", true),

	M00071(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00071", true),
	M00072(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00072", true),
	M00073(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00073", true),
	M00074(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00074", true),
	M00075(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00075", true),
	M00076(TipoMensaje. TECNICO, CategoriaMensaje.ERROR, "00076", true),

	M00077(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00077", true),
	M00078(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00078", true),
	M00079(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00079", true),
	M00080(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00080", true),
	M00081(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00081", true),
	M00082(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00082", true),
	M00083(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00083", true),
	M00084(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00084", true),
	M00085(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00085", true),
	M00086(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00086", true),
	M00087(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00087", true),
	M00088(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00088", true),
	M00089(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00089", true),
	M00090(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00090", true),
	M00091(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00091", true),
	M00092(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00092", true),
	M00093(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00093", true),
	M00094(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00094", true),
	M00095(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00095", true),
	M00096(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00096", true),
	M00097(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00097", true),
	M00098(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00098", true),
	M00099(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00099", true),


	M00115(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00115", true),
	M00116(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00116", true),
	M00117(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00117", true),
	M00118(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00118", true),
	M00119(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00119", true),
	M00120(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00120", true),
	M00121(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00121", true),
	M00122(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00122", true),
	M00123(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00123", true),
	M00124(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00124", true),
	M00125(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00125", true),
	M00126(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00126", true),
	M00127(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00127", true),
	M00128(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00128", true),
	M00129(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00129", true),
	M00130(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00130", true),
	M00131(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00131", true),
	M00132(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00132", true),
	M00133(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00133", true),
	M00134(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00134", true),
	M00135(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00135", true),
	M00136(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00136", true),
	M00137(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00137", true),
	M00138(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00138", true),
	M00139(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00139", true),
	M00140(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00140", true),
	M00141(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00141", true),
	M00142(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00142", true),
	M00143(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00143", true),
	M00144(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "001444", true),
	M00145(TipoMensaje. USUARIO, CategoriaMensaje.ERROR, "00145", true),







//Agregados para volver para arreglar el orden de los mensajes
	M00101(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00101",true),
	M00102(TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"00102",true),
	M00103(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00103", true),
	M00104(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00104", true),
	M00105(TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"00105",true),
	M00106(TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"00106",true),
	M00107(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00107", true),
	M00108(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00108", true),
	M00109(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00109", true);



	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String codigo;
	private boolean base;
	
	private CodigoMensaje(final TipoMensaje tipo, final CategoriaMensaje categoria, final String codigo, final boolean base) {
		setTipo(tipo);
		setCategoria(categoria);
		setCodigo(codigo);
		setBase(base);
	}
	
	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final CategoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getCodigo() {
		return codigo;
	}
	
	private final void setTipo(final TipoMensaje tipo) {
		this.tipo = tipo;
	}
	public final boolean isBase() {
		return base;
	}
	
	public String getIdentificador() {
		return concatenate(getTipo().name(),UNDERLINE,getCategoria().toString(),UNDERLINE,getCodigo());
	}
	
	private final void setCategoria(final CategoriaMensaje categoria) {
		this.categoria = categoria;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	private final void setBase(boolean base) {
		this.base = base;
	}
	
}
