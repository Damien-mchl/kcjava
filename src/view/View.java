package view;

import java.awt.*;

import javax.swing.*;

/**
 * vue du client
 */
public class View {
	private JFrame frame;
	private JPanel ctrlPane;
	private JFormattedTextField textUserId;
	private JButton butCheckinout;
	private JPanel timePanel;
	private JLabel labelDate;
	private JLabel roundedTime;
	private JPanel panel;
	private JTextField ip_textfield;
	private JFormattedTextField port_textfield;
	private JLabel ip_label;
	private JLabel label_port;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label_id;
	/**
	 * constructeur
	 * @param title titre de la fenetre
	 */
	public View(String title) {
        

 
        this.frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(400, 250));
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
        
               // Set the view layout
               this.ctrlPane = new JPanel();
               tabbedPane.addTab("Check In/Out", null, ctrlPane, null);
               ctrlPane.setLayout(new BorderLayout(10, 10));
               
               this.timePanel = new JPanel();
               ctrlPane.add(timePanel, BorderLayout.CENTER);
               
               this.labelDate = new JLabel();
               labelDate.setHorizontalAlignment(SwingConstants.CENTER);
               labelDate.setFont(new Font("Arial",Font.BOLD,20));
               
               this.roundedTime = new JLabel("");
               timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
               timePanel.add(labelDate);
               timePanel.add(roundedTime);
               
               panel_2 = new JPanel();
               ctrlPane.add(panel_2, BorderLayout.SOUTH);
               
               label_id = new JLabel("User ID");
               panel_2.add(label_id);
               this.textUserId = new JFormattedTextField();
               panel_2.add(textUserId);
               textUserId.setToolTipText("User Id");
               textUserId.setColumns(15);
               textUserId.setHorizontalAlignment(SwingConstants.CENTER);
               this.butCheckinout = new JButton("Check in/out");
               panel_2.add(butCheckinout);
               butCheckinout.setBackground(Color.LIGHT_GRAY);
               
               panel_1 = new JPanel();
               tabbedPane.addTab("Settings", null, panel_1, null);
               
               panel = new JPanel();
               panel_1.add(panel);
               
               ip_label = new JLabel("IP Address");
               panel.add(ip_label);
               
               ip_textfield = new JTextField();
               ip_textfield.setText("localhost");
               panel.add(ip_textfield);
               ip_textfield.setColumns(15);
               
               label_port = new JLabel("Port");
               panel.add(label_port);
               
               port_textfield = new JFormattedTextField();
               port_textfield.setText("3191");
               port_textfield.setColumns(6);
               panel.add(port_textfield);
		// Create views swing UI components
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getCtrlPane() {
		return ctrlPane;
	}
	public void setCtrlPane(JPanel ctrlPane) {
		this.ctrlPane = ctrlPane;
	}
	public JLabel getLabelDate() {
		return labelDate;
	}
	public void setLabelDate(JLabel labelDate) {
		this.labelDate = labelDate;
	}
	public JFormattedTextField getTextUserId() {
		return textUserId;
	}
	public void setTextUserId(JFormattedTextField textUserId) {
		this.textUserId = textUserId;
	}
	public JButton getButCheckinout() {
		return butCheckinout;
	}
	public void setButCheckinout(JButton butCheckinout) {
		this.butCheckinout = butCheckinout;
	}
	public JPanel getTimePanel() {
		return timePanel;
	}
	public void setTimePanel(JPanel timePanel) {
		this.timePanel = timePanel;
	}
	public JLabel getRoundedTime() {
		return roundedTime;
	}
	public void setRoundedTime(JLabel roundedTime) {
		this.roundedTime = roundedTime;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextField getIp_textfield() {
		return ip_textfield;
	}
	public void setIp_textfield(JTextField ip_textfield) {
		this.ip_textfield = ip_textfield;
	}
	public JFormattedTextField getPort_textfield() {
		return port_textfield;
	}
	public void setPort_textfield(JFormattedTextField port_textfield) {
		this.port_textfield = port_textfield;
	}
	public JLabel getIp_label() {
		return ip_label;
	}
	public void setIp_label(JLabel ip_label) {
		this.ip_label = ip_label;
	}
	public JLabel getLabel_port() {
		return label_port;
	}
	public void setLabel_port(JLabel label_port) {
		this.label_port = label_port;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	public JPanel getPanel_1() {
		return panel_1;
	}
	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}
	public JPanel getPanel_2() {
		return panel_2;
	}
	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
	public JLabel getLabel_id() {
		return label_id;
	}
	public void setLabel_id(JLabel label_id) {
		this.label_id = label_id;
	}
	
	
}
