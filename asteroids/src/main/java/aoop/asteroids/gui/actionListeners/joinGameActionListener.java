package aoop.asteroids.gui.actionListeners;

import aoop.asteroids.model.client.ClientPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Class that describes the actions application should perform when a player attempts to join a game from the menu.
 */
public class joinGameActionListener implements ActionListener {

    private JTextField ipField;
    private JTextField portField;
    private JTextField nickNameField;
    private JColorChooser colorChooser;

    public joinGameActionListener(JTextField ipField, JTextField portField, JTextField nickNameField, JColorChooser colorChooser) {
        this.ipField = ipField;
        this.portField = portField;
        this.nickNameField = nickNameField;
        this.colorChooser = colorChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ClientPlayer client = new ClientPlayer(InetAddress.getByName(ipField.getText()), Integer.parseInt(portField.getText()), nickNameField.getText(), colorChooser.getColor());
            new Thread(client).start();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }
}
