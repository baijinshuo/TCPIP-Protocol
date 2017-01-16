package TCPClient;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.PrintWriter;
import java.net.Socket;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * @author Jinshuo Bai
 *
 */
public class TCPClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	
	private PrintWriter writer;
	Socket socket;
	Container container;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCPClient frame = new TCPClient();
					frame.setVisible(true);
					frame.connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TCPClient() {
		super();
		final Address address = new Address();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		btnNewButton = new JButton("\u53D1\u9001");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				writer.print(address.getLocalname());
//				writer.print(":");
				writer.write(textField.getText());
				textArea.append(textField.getText() + "\n");
				textArea.setSelectionEnd(textArea.getText().length());
				textField.setText("");
			}
		});
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		
	}
	
	private void connect(){
		textArea.append("Connecting:\n");
		try {
			socket = new Socket("169.254.106.19",8877);
			writer = new PrintWriter(socket.getOutputStream(),true);
			textArea.append("Complete Connection\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
