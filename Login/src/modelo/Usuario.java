package modelo;

import javax.swing.ImageIcon;

public class Usuario
{
    private String nombre;
    private String contrasena;
    private String email;
    private ImageIcon avatar;
    
    

    public Usuario(String nombre, String contrasena) throws Exception
    {
        if (contrasena.length()<6)
            throw new Exception("Contraseña muy corta");
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setAvatar(ImageIcon avatar)
    {
        this.avatar = avatar;
    }

    public ImageIcon getAvatar()
    {
        return avatar;
    }
    public String toString()
    {return "Nombre de usuario: "+this.getNombre();
        }

}
