package test;

import controlador.Controlador;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import modelo.ConjuntoUsuarios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuiTestConjuntoConDatos
{
    Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestConjuntoConDatos()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        controlador.setOptionpane(op);
        ConjuntoUsuarios conjunto = controlador.getConjunto();
        conjunto.registrar("juan", "Qwerty123", "Qwerty123");
        conjunto.registrar("maria", "Zxcvbn789", "Zxcvbn789");
        conjunto.registrar("Pedro", "caramelo", "caramelo");
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVentana().setVisible(false);
    }

    @Test
    public void testCantidad()
    {
        Assert.assertEquals("Debe haber 3 usuarios registrados", 3, controlador.getConjunto().cantidadDeUsuarios());
    }

    @Test
    public void testLogOk()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("juan", robot);
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        TestUtils.clickComponent(aceptarLog, robot);
        Assert.assertEquals("Deberia coincidir el nombre de usuario con el nombre ingresado", "juan",
                            controlador.getUsuarioactual().getNombre());
    }

    @Test
    public void testLogUsuarioInexistente()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Juan Alberto", robot);
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        TestUtils.clickComponent(aceptarLog, robot);
        Assert.assertNull("Usuario actual debería ser null", controlador.getUsuarioactual());
    }

    @Test
    public void testLogContrasenaMal()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Pedro", robot);
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        TestUtils.clickComponent(aceptarLog, robot);
        Assert.assertNull("Usuario actual debería ser null", controlador.getUsuarioactual());
        Assert.assertEquals("Deberia decir: Contraseña incorrecta", "Contraseña incorrecta", op.getMensaje());
    }
    @Test
    public void testRegistroOk()
    {
        robot.delay(TestUtils.getDelay());
        ConjuntoUsuarios conjunto=controlador.getConjunto();
        int cantidad=conjunto.cantidadDeUsuarios();
        int cantidadactual;
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        TestUtils.clickComponent(aceptar, robot);
        cantidadactual=conjunto.cantidadDeUsuarios();
        Assert.assertEquals("Deberia haber un elemento mas que antes", cantidad+1, cantidadactual);
        Assert.assertNull("No debería haber excepcion",op.getMensaje());
    }
    @Test
    public void testRegistroTresYLogueo()
    {
        robot.delay(TestUtils.getDelay());
        ConjuntoUsuarios conjunto = controlador.getConjunto();
        int cantidad = conjunto.cantidadDeUsuarios();
        int cantidadactual;
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Leonoel", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        TestUtils.clickComponent(aceptar, robot);


        TestUtils.borraJTextField(nombre, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Adolfo", robot);
        TestUtils.borraJTextField(contra, robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("caramelo2016", robot);
        TestUtils.borraJTextField(confirma, robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("caramelo2016", robot);
        TestUtils.clickComponent(aceptar, robot);
        
        TestUtils.borraJTextField(nombre, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Cristian", robot);
        TestUtils.borraJTextField(contra, robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("pizzacalabresa", robot);
        TestUtils.borraJTextField(confirma, robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("pizzacalabresa", robot);
        TestUtils.clickComponent(aceptar, robot);


        cantidadactual = conjunto.cantidadDeUsuarios();
        Assert.assertEquals("Deberia haber tres elementos mas que antes", cantidad + 3, cantidadactual);
        
             robot.delay(TestUtils.getDelay());
             JTextField logNombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
             TestUtils.clickComponent(logNombre, robot);
             TestUtils.tipeaTexto("Adolfo", robot);
             JTextField logContrasena =
                 (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
             TestUtils.clickComponent(logContrasena, robot);
             TestUtils.tipeaTexto("caramelo2016", robot);
             JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
             TestUtils.clickComponent(aceptarLog, robot);
             Assert.assertEquals("Deberia coincidir el nombre de usuario con el nombre ingresado", "Adolfo",
                                 controlador.getUsuarioactual().getNombre());
        
         }
}
