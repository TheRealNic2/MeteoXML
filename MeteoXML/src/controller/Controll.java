package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import model.*;
import view.Window;

public class Controll implements ActionListener{
	
	private Window w;
	private String apiKey="19cfabb7e54e881ddc9edf8780ad2181";
	private static int meteo;
	public Controll(Window w) {
		this.w=w;
		
		w.getBtnNow().addActionListener(this);
		w.getBtn5Day().addActionListener(this);
		w.getBtnClear().addActionListener(this);

		w.setVisible(true);
		try {
		     URL defaultSound = getClass().getResource("/sounds/Meteo5.wav");
		     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(defaultSound);
		     Clip clip = AudioSystem.getClip();
		     clip.open(audioInputStream);
		     clip.start( );
		} catch (Exception ex) {
		     ex.printStackTrace();
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		w.getPnlSigla().setVisible(false);
		w.getPnlMain().setVisible(true);
		w.getTfCitta().requestFocus();
	}

	@SuppressWarnings("serial")
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(w.getBtnNow()==ev.getSource()) {
			if(connection()) {
				try {
					String s="";
					String city=""+w.getTfCitta().getText();
					String url="http://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=xml&appid="+apiKey;
					URL xmlFile = new URL(url);
					// Inizializzo Jaxb per dire che dovr� leggere l'xml in un certo modo
					JAXBContext jaxbContext = JAXBContext.newInstance(Current.class);
					// Il unmarshaller � l'oggetto che legge l'xml
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					Current c = (Current) jaxbUnmarshaller.unmarshal(xmlFile);
					w.getLblLatitudine2().setText(""+c.getCity().getCoord().getLat());
					w.getLblLongitudine2().setText(""+c.getCity().getCoord().getLon());
					w.getLblData2().setText(c.getLastupdate().getValue().getDay()+"/"+
											c.getLastupdate().getValue().getMonth()+"/"+
											c.getLastupdate().getValue().getYear());
					s=""+c.getLastupdate().getValue();
					for(int i=0;i<=10;i++) {
						s=removeCharAt(s,0);
					}
					w.getLblOra2().setText(s);
					w.getLblID2().setText(""+c.getCity().getId());
					
					//String unit=" "+c.getTemperature().getUnit();
					String unit="Celsius";
					s=""+Float.parseFloat(""+(Float.parseFloat(""+c.getTemperature().getValue())-273));
					s=arrotondamento(s);
					w.getLblTemperatura2().setText(""+s+" "+unit);
					Image image = null;
					if(Float.parseFloat(s)>=35) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/013-temperaturaAlta.png"));
					}
					else if(Float.parseFloat(s)>=15 && Float.parseFloat(s)<35) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/014-temperaturaMedia.png"));
					}
					else if(Float.parseFloat(s)>=0 && Float.parseFloat(s)<15) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/015-temperaturaBassa.png"));
					}
					else if(Float.parseFloat(s)<0) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/016-temperaturaBassissima.png"));
					}
					image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					ImageIcon icon = new ImageIcon(image);
					w.getLblTemperaturaImage().setIcon(icon);
					
					s=""+Float.parseFloat(""+(Float.parseFloat(""+c.getTemperature().getMax())-273));
					s=arrotondamento(s);
					w.getLblTemperaturaMassima2().setText(""+s+" "+unit);
					
					s=""+Float.parseFloat(""+(Float.parseFloat(""+c.getTemperature().getMin())-273));
					s=arrotondamento(s);
					w.getLblTemperaturaMinima2().setText(""+s+" "+unit);
					
					unit=" "+c.getHumidity().getUnit();
					w.getLblUmidita2().setText(""+c.getHumidity().getValue()+unit);
					unit=" "+c.getPressure().getUnit();
					w.getLblPressione2().setText(""+c.getPressure().getValue()+unit);
					
					w.getLblMeteo2().setText(nameTranslate(""+c.getWeather().getValue()));
					boolean isDay=false;
					if(c.getLastupdate().getValue().getHour()>6 && c.getLastupdate().getValue().getHour()<=18)
						isDay=true;
					image = null;
					if(Controll.meteo==1) {
						if(isDay)
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/001-sereno.png"));
						else
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/009-sereno2.png"));
					}
					else if(Controll.meteo==2) {
						if(isDay)
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/002-nuvoleSparse.png"));
						else
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/010-nuvoleSparse2.png"));
					}
					else if(Controll.meteo==3) {
						if(isDay)
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/003-nuvoloso.png"));
						else
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/011-nuvoloso2.png"));
					}
					else if(Controll.meteo==4) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/004-pioggiaLeggera.png"));
					}
					else if(Controll.meteo==5) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/005-pioggia.png"));
					}
					else if(Controll.meteo==6) {
						if(isDay)
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/006-nebbia.png"));
						else
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/012-nebbia2.png"));
					}
					else if(Controll.meteo==7) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/007-nevicataLeggera.png"));
					}
					else if(Controll.meteo==8) {
						image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/008-nevicata.png"));
					}
					image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
					icon = new ImageIcon(image);
					w.getLblMeteoImage().setIcon(icon);
					
					w.getLblNomeVento2().setText(nameTranslate(""+c.getWind().getSpeed().getName()));
					w.getLblVelocitaVento2().setText(""+c.getWind().getSpeed().getValue());
					w.getLblDirezioneVento2().setText(""+c.getWind().getDirection().getValue()+
							" "+c.getWind().getDirection().getName());
					
					System.out.println(c.getCity().getName());
	
				} catch (Exception e) {
					JOptionPane.showMessageDialog(w, "Citt� NON Trovata.", "NotFound", 0);
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(w, "Non c'� connessione ad Internet!", "ERR_INTERNET_DISCONNECTED", 0);
			}
			w.getTfCitta().requestFocus();
		}
		else if(w.getBtn5Day()==ev.getSource()) {
			if(connection()) {
				try {
					String s="";
					String city=""+w.getTfCitta().getText();
					String url="http://api.openweathermap.org/data/2.5/forecast?q="+city+"&mode=xml&appid="+apiKey;
					//String url="Forecast.xml";
					URL xmlFile = new URL(url);
					// Inizializzo Jaxb per dire che dovr� leggere l'xml in un certo modo
					JAXBContext jaxbContext = JAXBContext.newInstance(Weatherdata.class);
					// Il unmarshaller � l'oggetto che legge l'xml
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					Weatherdata c = (Weatherdata) jaxbUnmarshaller.unmarshal(xmlFile);
					w.getLblLatitudine2().setText(""+c.getLocation().getLocation().getLatitude());
					w.getLblLongitudine2().setText(""+c.getLocation().getLocation().getLongitude());
					
					ArrayList<String> momentFrom=new ArrayList<String>();
					ArrayList<String> momentTo=new ArrayList<String>();
					for(int i=0;i<c.getForecast().getTime().size();i++) {
						s=""+c.getForecast().getTime().get(i).getFrom();
						for(int j=0;j<=10;j++) {
							s=removeCharAt(s,0);
						}
						momentFrom.add(""+c.getForecast().getTime().get(i).getFrom().getDay()+"/"+
								c.getForecast().getTime().get(i).getFrom().getMonth()+"/"+
								c.getForecast().getTime().get(i).getFrom().getYear()+"      "+s);
						
						s=""+c.getForecast().getTime().get(i).getTo();
						for(int j=0;j<=10;j++) {
							s=removeCharAt(s,0);
						}
						momentTo.add(""+c.getForecast().getTime().get(i).getTo().getDay()+"/"+
								c.getForecast().getTime().get(i).getTo().getMonth()+"/"+
								c.getForecast().getTime().get(i).getTo().getYear()+"      "+s);
					}
					JScrollPane scrollPane=new JScrollPane();
					JTable table=new JTable();
					scrollPane.setViewportView(table);
					DefaultTableModel model=new DefaultTableModel(){@Override
						public boolean isCellEditable(int row, int col) {
						return false;
						}
					};
					Object[] colums={"Da","A"};
					table.setModel(model);
					model.setColumnIdentifiers(colums);
					table.getColumnModel().getColumn(0).setMinWidth(150);
					table.getColumnModel().getColumn(0).setMaxWidth(150);
					table.getColumnModel().getColumn(0).setPreferredWidth(150);
					table.getColumnModel().getColumn(1).setMinWidth(150);
					table.getColumnModel().getColumn(1).setMaxWidth(150);
					table.getColumnModel().getColumn(1).setPreferredWidth(150);
					Object[] rows=new Object[2];
					for(int i=0;i<c.getForecast().getTime().size();i++) {
						rows[0]=momentFrom.get(i);
						rows[1]=momentTo.get(i);
						model.addRow(rows);
						table.setRowHeight(30);
					}
					scrollPane.setPreferredSize(new Dimension(308, 200));
					JPanel pnl=new JPanel();
					pnl.setBackground(Color.CYAN);
					scrollPane.setOpaque(false);
					pnl.add(scrollPane);
					JOptionPane.showMessageDialog(w, pnl, "Seleziona Periodo", 1);
					try {
						int sel=table.getSelectedRow();
						
						w.getLblID2().setText(""+c.getLocation().getLocation().getGeobaseid());
						
						w.getLblData2().setText(""+c.getForecast().getTime().get(sel).getFrom().getDay()+"/"+
												c.getForecast().getTime().get(sel).getFrom().getMonth()+"/"+
												c.getForecast().getTime().get(sel).getFrom().getYear());
						s=""+c.getForecast().getTime().get(sel).getFrom();
						for(int i=0;i<=10;i++) {
							s=removeCharAt(s,0);
						}
						w.getLblOra2().setText(s);
	
						s="";
						String unit="Celsius";
						s=""+(Float.parseFloat(""+c.getForecast().getTime().get(sel).getTemperature().getValue())-273);
						s=arrotondamento(s);
						w.getLblTemperatura2().setText(""+s+" "+unit);
						Image image = null;
						if(Float.parseFloat(s)>=35) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/013-temperaturaAlta.png"));
						}
						else if(Float.parseFloat(s)>=15 && Float.parseFloat(s)<35) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/014-temperaturaMedia.png"));
						}
						else if(Float.parseFloat(s)>=0 && Float.parseFloat(s)<15) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/015-temperaturaBassa.png"));
						}
						else if(Float.parseFloat(s)<0) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/016-temperaturaBassissima.png"));
						}
						image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
						ImageIcon icon = new ImageIcon(image);
						w.getLblTemperaturaImage().setIcon(icon);
						
						s=""+(Float.parseFloat(""+c.getForecast().getTime().get(sel).getTemperature().getMax())-273);
						s=arrotondamento(s);
						w.getLblTemperaturaMassima2().setText(""+s+" "+unit);
						
						s=""+(Float.parseFloat(""+c.getForecast().getTime().get(sel).getTemperature().getMin())-273);
						s=arrotondamento(s);
						w.getLblTemperaturaMinima2().setText(""+s+" "+unit);
						
						unit=" "+c.getForecast().getTime().get(sel).getHumidity().getUnit();
						w.getLblUmidita2().setText(""+c.getForecast().getTime().get(sel).getHumidity().getValue()+unit);
						unit=" "+c.getForecast().getTime().get(sel).getPressure().getUnit();
						w.getLblPressione2().setText(""+c.getForecast().getTime().get(sel).getPressure().getValue()+unit);
						
						w.getLblMeteo2().setText(nameTranslate(""+c.getForecast().getTime().get(sel).getSymbol().getName()));
						boolean isDay=false;
						if(c.getForecast().getTime().get(sel).getFrom().getHour()>6 && c.getForecast().getTime().get(sel).getFrom().getHour()<=18)
							isDay=true;
						image = null;
						if(Controll.meteo==1) {
							if(isDay)
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/001-sereno.png"));
							else
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/009-sereno2.png"));
						}
						else if(Controll.meteo==2) {
							if(isDay)
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/002-nuvoleSparse.png"));
							else
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/010-nuvoleSparse2.png"));
						}
						else if(Controll.meteo==3) {
							if(isDay)
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/003-nuvoloso.png"));
							else
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/011-nuvoloso2.png"));
						}
						else if(Controll.meteo==4) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/004-pioggiaLeggera.png"));
						}
						else if(Controll.meteo==5) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/005-pioggia.png"));
						}
						else if(Controll.meteo==6) {
							if(isDay)
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/006-nebbia.png"));
							else
								image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/012-nebbia2.png"));
						}
						else if(Controll.meteo==7) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/007-nevicataLeggera.png"));
						}
						else if(Controll.meteo==8) {
							image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/008-nevicata.png"));
						}
						image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
						icon = new ImageIcon(image);
						w.getLblMeteoImage().setIcon(icon);
						
						w.getLblNomeVento2().setText(nameTranslate(""+c.getForecast().getTime().get(sel).getWindSpeed().getName()));
						w.getLblVelocitaVento2().setText(""+c.getForecast().getTime().get(sel).getWindSpeed().getMps());
						w.getLblDirezioneVento2().setText(""+c.getForecast().getTime().get(sel).getWindDirection().getDeg()+
								" "+c.getForecast().getTime().get(sel).getWindDirection().getName());
					}
					catch(Exception e) {
						System.out.println("Error Selection");
					}
					
					System.out.println(c.getLocation().getName());
	
				} catch (Exception e) {
					JOptionPane.showMessageDialog(w, "Citt� NON Trovata.", "NotFound", 0);
				}
			}
			else {
				JOptionPane.showMessageDialog(w, "Non c'� connessione ad Internet!", "ERR_INTERNET_DISCONNECTED", 0);
			}
			w.getTfCitta().requestFocus();
		}
		else if(w.getBtnClear()==ev.getSource()) {
			w.getLblLatitudine2().setText("");
			w.getLblLongitudine2().setText("");
			w.getLblData2().setText("");
			w.getLblOra2().setText("");
			w.getLblID2().setText("");
			
			w.getLblTemperatura2().setText("");
			w.getLblTemperaturaMassima2().setText("");
			w.getLblTemperaturaMinima2().setText("");
			
			w.getLblUmidita2().setText("");
			
			w.getLblPressione2().setText("");
			
			w.getLblMeteo2().setText("");
			
			w.getLblNomeVento2().setText("");
			w.getLblVelocitaVento2().setText("");
			w.getLblDirezioneVento2().setText("");
			
			w.getLblTemperaturaImage().setIcon(null);
			w.getLblMeteoImage().setIcon(null);
			
			w.getTfCitta().setText("");
			w.getTfCitta().requestFocus();
		}
	}
	
	private static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}
	
	private String nameTranslate(String name) {
		String s="";
		if(name.equals("Calm") || name.equals(""))
			s="Calmo";
		else if((name.toLowerCase()).equals("light breeze"))
			s="Leggera Brezza";
		else if((name.toLowerCase()).equals("gentle breeze"))
			s="Dolce Brezza";
		else if((name.toLowerCase()).equals("moderate breeze"))
			s="Brezza Moderata";
		else if((name.toLowerCase()).equals("fresh breeze"))
			s="Brezza Fredda";
		else if((name.toLowerCase()).equals("clear sky")) {
			s="Sereno";
			Controll.meteo=1;
		}
		else if((name.toLowerCase()).equals("scattered clouds") || (name.toLowerCase()).equals("broken clouds")) {
			s="Nuvole Sparse";
			Controll.meteo=2;
		}
		else if((name.toLowerCase()).equals("few clouds")) {
			s="Poco Nuvoloso";
			Controll.meteo=2;
		}
		else if((name.toLowerCase()).equals("mist")) {
			s="Variabile";
			Controll.meteo=2;
		}
		else if((name.toLowerCase()).equals("overcast clouds")) {
			s="Nuvoloso";
			Controll.meteo=3;
		}
		else if((name.toLowerCase()).equals("light rain")) {
			s="Pioggia Leggera";
			Controll.meteo=4;
		}
		else if((name.toLowerCase()).equals("moderate rain")) {
			s="Pioggia";
			Controll.meteo=5;
		}
		else if((name.toLowerCase()).equals("fog")) {
			s="Nebbia";
			Controll.meteo=6;
		}
		else if((name.toLowerCase()).equals("light snow")) {
			s="Nevicata Leggera";
			Controll.meteo=7;
		}
		else if((name.toLowerCase()).equals("moderate snow")) {
			s="Nevicata";
			Controll.meteo=8;
		}
		else {
			s=name;
			System.out.println("|"+name+"|");
		}
		return s;
	}
	
	private static String arrotondamento(String s) {
		boolean trov=false;
		int i=0;
		String s2="";
		while(trov==false && i<s.length()) {
			s2=s2+s.charAt(i);
			if((""+s.charAt(i)).equals("."))
				trov=true;
			else{
				i++;
			}
		}
		try {
			if(trov==true) {
				s2=s2+s.charAt(i+1);
				s2=s2+s.charAt(i+2);
			}
		} catch(Exception e) {}
		return s2;
	}
	
	private static boolean connection() {
		try {
			URL url = new URL("http://www.google.com");
			URLConnection uc = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line;
			line = br.readLine();
			if(line!=null)
				return true;
		} catch(Exception e) {}
		return false;
	}
}
