import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.EmailCliente;
import org.example.NotificadorEmail;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");


        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "No fue encontrado ");


        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", null);
    }
    //esto lo agregue para ver si la direccion es nula dnawhfb
    @Test
    public void testNotificarConDireccionNula(){
        NotificadorEmail notificador=new NotificadorEmail(emailClienteMock);
        notificador.notificar(null,"No fue encontrado ");
        verify(emailClienteMock,times(0)).enviarCorreo(anyString(),anyString());
    }
}
