import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class GUI {
  static void buildGUI() {
    JFrame frame = setUpFrame();

    JPanel panel = setUpPanel(frame);
    frame.getContentPane().add(panel);

    JLabel comboLabel = setUpComboLabel();
    panel.add(comboLabel);

    JComboBox comboBox = setUpComboBox();
    panel.add(comboBox);

    JLabel label = setUpLabel();
    panel.add(label);

    JTextField textField = setUpTextField();
    panel.add(textField);

    JButton button = setUpButton();
    panel.add(button);

    JTextArea textArea = setUpTextArea();
    JScrollPane scroller = setUpScroller(textArea);
    panel.add(scroller);

    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

      }
    });

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        textArea.setText(null); // clears the log each time the button is pressed

        Links links = new Links();
        Connector connector = new Connector(links.siteMain);
        StringBuilder infoString = connector.getDataFromAPI((String) comboBox.getSelectedItem());
        JSONArray jsonArray = connector.getJSONArray(infoString);

        System.out.println("Saving JSONArray index to JSONObject...");
        JSONObject jsonObject = null;
        boolean successful = false;
        boolean caught = false;
        try {
          jsonObject = (JSONObject) jsonArray.get(Integer.valueOf(textField.getText()) - 1);
          successful = true;
          System.out.println("Successful");
        } catch (Exception e) {
          textArea.append("Invalid input. Enter a value between 1 and " + jsonArray.size() + ".");
          textArea.append(System.lineSeparator());
          textArea.append(System.lineSeparator());
          caught = true;
        }
        
        StringBuilder formattedData = null;
        if (successful) {
          formattedData = Formatter.tryFormatting(jsonObject);
          if (formattedData != null) {
            textArea.append("Data for " + (String) comboBox.getSelectedItem() + "(" + textField.getText() + "):");
            textArea.append(System.lineSeparator());
            textArea.append(System.lineSeparator());
            textArea.append(formattedData.toString());
          }
          else if (formattedData == null && caught == false) {
            textArea.append("Something went wrong.");
            System.out.println("Formatting failed, printing data");
            System.out.println("JSONObject: " + jsonObject);
            System.out.println("Formatted StringBuilder: " + formattedData);
          }
        }
      }
    });

    frame.setVisible(true);
  }

  static JFrame setUpFrame() {
    JFrame frame = new JFrame("Data");
    int frameWidth = 800;
    int frameHeight = 550;
    frame.setSize(frameWidth, frameHeight);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    return frame;
  }

  static JPanel setUpPanel(JFrame frame) {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, frame.getWidth(), 10, frame.getWidth()));
    return panel;
  }

  static JLabel setUpComboLabel() {
    JLabel comboLabel = new JLabel("Select a data type:");
    return comboLabel;
  }

  static JComboBox setUpComboBox() {
    Links paths = new Links();
    String[] pathStrings = {
        paths.postsPath,
        paths.commentsPath,
        paths.albumsPath,
        paths.photosPath,
        paths.todosPath,
        paths.usersPath
    };
    JComboBox comboBox = new JComboBox(pathStrings);
    comboBox.setMaximumRowCount(8);
    return comboBox;
  }

  static JLabel setUpLabel() {
    JLabel label = new JLabel("Enter an ID number:");
    return label;
  }

  static JTextField setUpTextField() {
    JTextField textField = new JTextField(15);
    return textField;
  }

  static JButton setUpButton() {
    JButton button = new JButton("Get Data");
    return button;
  }

  static JTextArea setUpTextArea() {
    JTextArea textArea = new JTextArea(10, 25);
    textArea.setMargin(new Insets(10, 10, 10, 10));
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setCaretPosition(textArea.getDocument().getLength());
    return textArea;
  }

  static JScrollPane setUpScroller(JTextArea textArea) {
    JScrollPane scroller = new JScrollPane(textArea);
    // scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    return scroller;
  }
}