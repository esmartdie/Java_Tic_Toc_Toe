package Reto18;


import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;

public class TresEnLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MarcoTresEnLinea miMarco=new MarcoTresEnLinea();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
	}

}

class MarcoTresEnLinea extends JFrame{
	
	public MarcoTresEnLinea() {
		
		this.setTitle("Tres en Linea");
		
		setVisible(true);
		
		setBounds(550, 300, 500, 300);
		
		LaminaTresEnLinea miLamina=new LaminaTresEnLinea();
		
		add(miLamina);
		
		
	}
}

class LaminaTresEnLinea extends JPanel{
	
	public LaminaTresEnLinea() {
		
		setLayout(new BorderLayout());
		
		pantalla=new JLabel ("Bienvenido al Tres en Linea, elige X o O");
		
		pantalla.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		pantalla.setForeground(Color.BLACK);
		
		pantalla.setHorizontalAlignment(JLabel.CENTER);
		
		add(pantalla, BorderLayout.NORTH);
		
		miLamina2=new JPanel();
		
		miLamina2.setLayout(new GridLayout(3,3));
		
		grupoBotones=new ButtonGroup();
		
		ponerBoton("", 0, 0);
		
		ponerBoton("", 0, 1);
		
		ponerBoton("", 0, 2);
		
		ponerBoton("", 1, 0);
		
		ponerBoton("", 1, 1); 
		
		ponerBoton("", 1, 2);
		
		ponerBoton("", 2, 0);
		
		ponerBoton("", 2, 1);
		
		ponerBoton("", 2, 2);
		
		add(miLamina2, BorderLayout.CENTER);
		
		laminaBotones=new JPanel();
		
		grupoRadio=new ButtonGroup();		
		
		colocarBotonesRadio("X", false);
		
		colocarBotonesRadio("O", false);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
					
	}
	

	
	private void ponerBoton(String rotulo, int indicePrimero, int indiceSegundo) {
		
		JButton boton=new JButton(rotulo);
				
		grupoBotones.add(boton);
		
		miLamina2.add(boton);
		
		
		ActionListener eventoJugador=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean habilitarBotones=false;
				
				if( turnos %2!=0) {
					
					boton.setText(escritura);
					cambiaColorBotones(boton);
					matriz[indicePrimero][indiceSegundo]=boton.getText();
					
				}else {
					if(escritura.equals("X")) {
						boton.setText("O");
						cambiaColorBotones(boton);
						matriz[indicePrimero][indiceSegundo]=boton.getText();
					}
					else {
						boton.setText("X");
						cambiaColorBotones(boton);
						matriz[indicePrimero][indiceSegundo]=boton.getText();
					}
				
				}
				
				turnos++;
								
				while(turnos>chec) {
					
					if(matriz[0][0].equals(matriz[0][1]) && matriz[0][1].equals(matriz[0][2])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][0] );			
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[1][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[1][2])) {
						
						pantalla.setText("Gana jugador: " + matriz[1][0] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[2][0].equals(matriz[2][1]) && matriz[2][1].equals(matriz[2][2])) {
						
						pantalla.setText("Gana jugador: " + matriz[2][0] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[0][0].equals(matriz[1][0]) && matriz[1][0].equals(matriz[2][0])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][0] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[0][1].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][1])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][1] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[0][2].equals(matriz[1][2]) && matriz[1][2].equals(matriz[2][2])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][2] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][0] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					else if(matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])) {
						
						pantalla.setText("Gana jugador: " + matriz[0][2] );
						habilitarBotonesGrupo(grupoBotones, habilitarBotones);
						
					}
					
					if(turnos==10 && pantalla.getText().equals("Bienvenido al Tres en Linea")) {
						
						pantalla.setText("Felicidades a ambos, es un empate" );
					}
					chec++;
				}

													
			}
			
				
		};
		
				
		boton.addActionListener(eventoJugador);
		
	}
	
	public void colocarBotonesRadio(String nombre, boolean seleccion) {
		
		JRadioButton botonRadio=new JRadioButton(nombre, seleccion);
		
		grupoRadio.add(botonRadio);
		
		laminaBotones.add(botonRadio);
	
		ActionListener miEvento=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				escritura=nombre;
				botonRadioOn=true;
				
			}
			
			
		};
		
		botonRadio.addActionListener(miEvento);
	}
	
	
	public static void habilitarBotonesGrupo(ButtonGroup grupoBotones, boolean habilitar) {
			
		Enumeration<AbstractButton> botones = grupoBotones.getElements();
		
		while (botones.hasMoreElements())
		  {
			botones.nextElement().setEnabled(habilitar);
		  }
		
	}
	
	public void cambiaColorBotones (JButton botonsito) {
			
		if(botonsito.getText().equals("X")) {
			botonsito.setEnabled(false);
			botonsito.setBackground(Color.RED);
			botonsito.setFont(new Font("Dialog", Font.BOLD, 20));
		}
		else {
			botonsito.setEnabled(false);
			botonsito.setBackground(Color.BLUE);
			botonsito.setFont(new Font("Dialog", Font.BOLD, 20));
		}
	}

	

	private String matriz[][]=new String [][] {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
	private static int turnos=1;
	private int chec=1;
	private JLabel pantalla;
	private JPanel miLamina2;
	private ButtonGroup grupoBotones;
	private ButtonGroup grupoRadio;
	private boolean botonRadioOn=false;
	private JPanel laminaBotones;
	private String escritura;
}
