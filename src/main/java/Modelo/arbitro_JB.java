package Modelo;

public class arbitro_JB extends participante_JB {
    private String direccion;
    private String tel_contac;

    public arbitro_JB() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel_contac() {
        return tel_contac;
    }

    public void setTel_contac(String tel_contac) {
        this.tel_contac = tel_contac;
    }
}
