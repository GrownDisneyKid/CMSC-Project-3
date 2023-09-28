import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField inputField;
    private JTextArea outputArea;
    private BinaryTree binaryTree;

    public Main() {
        setTitle("Binary Tree GUI");
        setSize(600, 200); // Wider than taller
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(30);
        inputPanel.add(new JLabel("Enter Binary Tree:"));
        inputPanel.add(inputField);

        // Buttons Panel with FlowLayout
        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton balancedButton = new JButton("Balanced");
        balancedButton.addActionListener(this);
        JButton fullButton = new JButton("Full");
        fullButton.addActionListener(this);
        JButton properButton = new JButton("Proper");
        properButton.addActionListener(this);
        JButton heightButton = new JButton("Height");
        heightButton.addActionListener(this);
        JButton nodeCountButton = new JButton("Node Count");
        nodeCountButton.addActionListener(this);
        JButton inorderButton = new JButton("Inorder Traversal");
        inorderButton.addActionListener(this);
        JButton finalOrderButton = new JButton("Final Order"); 
        finalOrderButton.addActionListener(this);

        // Add the check buttons and final order button to the buttons panel
        buttonsPanel.add(balancedButton);
        buttonsPanel.add(fullButton);
        buttonsPanel.add(properButton);
        buttonsPanel.add(heightButton);
        buttonsPanel.add(nodeCountButton);
        buttonsPanel.add(inorderButton);
        buttonsPanel.add(finalOrderButton);

        // Result Panel
        JPanel resultPanel = new JPanel();
        outputArea = new JTextArea(0, 30); // Match input size (5 rows, 30 columns)
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        resultPanel.add(new JLabel("Result:"));
        resultPanel.add(scrollPane);

        // Add panels to the frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonsPanel, BorderLayout.CENTER);
        contentPane.add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
        binaryTree = new BinaryTree();
    }

    // ... actionPerformed, createCheckButton, and createOrderButton methods ...

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();
        binaryTree.constructTree(input);

        String result = "";

        // Check which button was clicked and display the corresponding result
        if (e.getActionCommand().equals("Balanced")) {
            result = "Balanced: " + binaryTree.isBalanced();
        } else if (e.getActionCommand().equals("Full")) {
            result = "Full: " + binaryTree.isFull();
        } else if (e.getActionCommand().equals("Proper")) {
            result = "Proper: " + binaryTree.isProper();
        } else if (e.getActionCommand().equals("Height")) {
            result = "Height: " + binaryTree.getHeight();
        } else if (e.getActionCommand().equals("Node Count")) {
            result = "Node Count: " + binaryTree.getNodeCount();
        } else if (e.getActionCommand().equals("Inorder Traversal")) {
            result = "Inorder Traversal: " + binaryTree.inorderTraversal();
        } else if (e.getActionCommand().equals("Tree Order")) { 
            result = "Tree Order: " + binaryTree.finalOrder();
        }

        outputArea.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
