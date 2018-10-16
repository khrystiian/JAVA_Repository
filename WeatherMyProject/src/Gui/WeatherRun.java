package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import WeatherInfo.BaseObj;
import WeatherInfo.Clouds;
import WeatherInfo.Wind;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class WeatherRun extends JFrame {

	private JPanel contentPane;
	private JTextField txtCity;
	private JTextField txtClouds;
	private JTextField txtWeather;
	private JTextField txtWind;
	private JTextField txtTemp;
	private JTextField txtHumidity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherRun frame = new WeatherRun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WeatherRun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCity = new JLabel("Clouds");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCity.setBounds(27, 231, 91, 26);
		contentPane.add(lblCity);
		
		JLabel label = new JLabel("City");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(74, 154, 57, 26);
		contentPane.add(label);
		
		JLabel lblWeather = new JLabel("Weather");
		lblWeather.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblWeather.setBounds(27, 296, 91, 26);
		contentPane.add(lblWeather);
		
		JLabel lblWind = new JLabel("Wind");
		lblWind.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblWind.setBounds(27, 372, 91, 26);
		contentPane.add(lblWind);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTemperature.setBounds(27, 442, 126, 26);
		contentPane.add(lblTemperature);
		
		txtCity = new JTextField();
		txtCity.setBounds(143, 155, 199, 26);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		txtClouds = new JTextField();
		txtClouds.setEditable(false);
		txtClouds.setColumns(10);
		txtClouds.setBounds(139, 232, 155, 26);
		contentPane.add(txtClouds);
		
		txtWeather = new JTextField();
		txtWeather.setEditable(false);
		txtWeather.setColumns(10);
		txtWeather.setBounds(139, 297, 155, 26);
		contentPane.add(txtWeather);
		
		txtWind = new JTextField();
		txtWind.setEditable(false);
		txtWind.setColumns(10);
		txtWind.setBounds(139, 373, 155, 26);
		contentPane.add(txtWind);
		
		txtTemp = new JTextField();
		txtTemp.setEditable(false);
		txtTemp.setColumns(10);
		txtTemp.setBounds(139, 442, 155, 26);
		contentPane.add(txtTemp);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCity.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please insert the city name", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String city  = txtCity.getText().replace("", "%20");
				checkWeather(city);
			}
		});
		btnStart.setBounds(588, 372, 97, 25);
		contentPane.add(btnStart);
		
		JLabel lblWeather_1 = new JLabel("Weather in your city");
		lblWeather_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblWeather_1.setBounds(259, 49, 259, 35);
		contentPane.add(lblWeather_1);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblHumidity.setBounds(27, 499, 126, 26);
		contentPane.add(lblHumidity);
		
		txtHumidity = new JTextField();
		txtHumidity.setEditable(false);
		txtHumidity.setColumns(10);
		txtHumidity.setBounds(139, 499, 155, 26);
		contentPane.add(txtHumidity);
	}
	
	private void checkWeather(String city){
		
		try{
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+ city+"&appid=b1b15e88fa797225412429c1c50c122a");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			InputStream is = con.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String inputLine = "";
			while((inputLine = reader.readLine()) != null){
				System.out.println(inputLine);
				Gson g = new Gson();
		  BaseObj bo = g.fromJson(inputLine, BaseObj.class);
				txtTemp.setText(bo.getMain().getTemp());
				txtHumidity.setText(bo.getMain().getHumidity());
				txtWeather.setText(bo.getWeather().get(0).getDescription());
		  Clouds cl = g.fromJson(inputLine, Clouds.class);
				txtClouds.setText(bo.getClouds().getAll());
		        txtWind.setText(bo.getWind().getSpeed());				
			}
		}
			catch(IOException e){
				e.printStackTrace();
			}
				}
	}

