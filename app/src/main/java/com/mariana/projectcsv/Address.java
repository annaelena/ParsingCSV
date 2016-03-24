package com.mariana.projectcsv;


public class Address {

    private String numCivico;
    private String tipoVia;
    private String citta;
    private String indirizzo;
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }




    public String getNumCivico() {
        return numCivico;
    }
    public void setNumCivico(String numCivico) {
        this.numCivico = numCivico;
    }
    public String getTipoVia() {
        return tipoVia;
    }
    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    @Override
    public String toString(){
        return id + " " + tipoVia + " " + indirizzo + ", " + numCivico + " " + citta;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address)){
            return false;
        }
        Address a = (Address)o;
        return tipoVia.equals(a.tipoVia)
                && indirizzo.equals(a.indirizzo)
                && numCivico.equals(a.numCivico);
    }

    @Override
    public int hashCode(){
        return tipoVia.hashCode() + indirizzo.hashCode() + numCivico.hashCode();
    }

/*class AddressTree implements Comparable<AddressTree>{


		@Override

		public boolean equals(Object o){
			if(!(o instanceof AddressTree)){
				return false;
			}
			 AddressTree  b = (AddressTree)o;
			 return ;
		}*/
		/*@Override

		public int compareTo(AddressTree b){
			return  ;
		}*/



}
