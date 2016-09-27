package test;

import controlador.Controlador;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuiTestEnabledDisabled
{
    Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestEnabledDisabled()
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
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVentana().setVisible(false);
    }

    /**
     * @see Controlador#actionPerformed(java.awt.event.ActionEvent)
     */
    @Test
    public void testRegSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    @Test
    public void testVacios()
    {
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    @Test
    public void testRegSoloContrasena()
    {
        robot.delay(TestUtils.getDelay());
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSoloConfirma()
    {
        robot.delay(TestUtils.getDelay());
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegTresLlenos()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertTrue("El boton de registro deberia estar hablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSinConfirma()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSinContrasena()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);

        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }


    @Test
    public void testRegSinNombre()
    {
        robot.delay(TestUtils.getDelay());

        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");

        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testConfirmacionMal()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("holis", robot);
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        TestUtils.clickComponent(aceptar, robot);
        Assert.assertEquals("Deberia decir: Contraseña y confirmacion no coinciden", "Contraseña y confirmacion no coinciden",
                            op.getMensaje());
    }
    @Test
    public void testRegContrasenaCorta()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        TestUtils.clickComponent(aceptar, robot);
        Assert.assertEquals("Deberia decir: contraseña corta", "Contraseña muy corta",
                            op.getMensaje());
    }
    
    @Test
    public void testLogSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    
    @Test
    public void testLogSoloContra()
    {
        robot.delay(TestUtils.getDelay());
        JTextField contrasena = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    
    @Test
    public void testLogLleno()
    {
        robot.delay(TestUtils.getDelay());
        JTextField contrasena = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("hola", robot);
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("hola", robot);
        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
        Assert.assertTrue("El boton de login deberia estar hablitado", aceptarLog.isEnabled());
    }
    
    
    
    
}
