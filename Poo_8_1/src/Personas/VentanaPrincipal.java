package Personas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private ListaPersonas lista;
    private Container contenedor;

    private JLabel nombre, apellidos, telefono, direccion;
    private JTextField campoNombre, campoApellidos, campoTelefono, campoDireccion; 
    private JButton añadir, eliminar, borrarLista;
    private JList<String> listaNombres;
    private DefaultListModel<String> modelo;
    private JScrollPane scrollLista;

    public VentanaPrincipal() {
        lista = new ListaPersonas();
        inicio();
        setTitle("Personas");
        setSize(270, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombre = new JLabel("Nombre: ");
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(105, 20, 135, 23);

        apellidos = new JLabel("Apellidos: ");
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(105, 50, 135, 23);

        telefono = new JLabel("Teléfono: ");
        telefono.setBounds(20, 80, 135, 23);
        campoTelefono = new JTextField();
        campoTelefono.setBounds(105, 80, 135, 23);

        direccion = new JLabel("Dirección: ");
        direccion.setBounds(20, 110, 135, 23);
        campoDireccion = new JTextField();
        campoDireccion.setBounds(105, 110, 135, 23);

        añadir = new JButton("Añadir");
        añadir.setBounds(105, 150, 80, 23);
        añadir.addActionListener(this);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(20, 280, 80, 23);
        eliminar.addActionListener(this);

        borrarLista = new JButton("Borrar Lista");
        borrarLista.setBounds(120, 280, 120, 23);
        borrarLista.addActionListener(this);

        modelo = new DefaultListModel<>();
        listaNombres = new JList<>(modelo);
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollLista = new JScrollPane(listaNombres);
        scrollLista.setBounds(20, 190, 220, 80);

        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(telefono);
        contenedor.add(campoTelefono);
        contenedor.add(direccion);
        contenedor.add(campoDireccion);
        contenedor.add(añadir);
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == añadir) {
            añadirPersona();
        } else if (evento.getSource() == eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());
        } else if (evento.getSource() == borrarLista) {
            borrarLista();
        }
    }

    private void añadirPersona() {
        Persona p = new Persona(
                campoNombre.getText(),
                campoApellidos.getText(),
                campoTelefono.getText(),
                campoDireccion.getText()
        );
        lista.añadirPersona(p);

        String elemento = campoNombre.getText() + " - " + campoDireccion.getText();
        modelo.addElement(elemento);
        listaNombres.setModel(modelo);

        campoNombre.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoDireccion.setText("");
    }

    private void eliminarNombre(int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            lista.eliminarPersona(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarLista() {
        lista.borrarLista();
        modelo.clear();
    }
}
