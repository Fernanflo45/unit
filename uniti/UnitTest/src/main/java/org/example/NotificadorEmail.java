package org.example;


public class NotificadorEmail {
    private org.example.EmailCliente emailCliente;

    public NotificadorEmail(org.example.EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if (direccion==null || direccion.isEmpty()){
            return;
        }
        emailCliente.enviarCorreo(direccion,mensaje);
    }
}
