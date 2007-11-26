package scr.entidades;

public class Session {
	private static Session ses;
	private Usuario usuario;
	private Session(){
	}
	public static Session getInstance(){
		if(ses==null)
			createInstance();
		return ses;
	}
	private synchronized static void createInstance(){
		if(ses==null){
			ses = new Session();
		}
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
