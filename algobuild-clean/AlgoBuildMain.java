import algobuild.model.Document;
import algobuild.model.blocks.*;
import algobuild.view.blocks.*;

import javax.swing.*;
import java.awt.*;

/**
 * Main di test per verificare il rendering dei blocchi.
 * Questo è temporaneo - sarà sostituito dalla main window completa.
 */
public class AlgoBuildMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Crea finestra di test
            JFrame frame = new JFrame("AlgoBuild - Test Rendering");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Crea documento
            Document document = new Document("Test");

            // Crea panel principale con layout verticale
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBackground(Color.WHITE);

            // Aggiungi alcuni blocchi per testare il rendering

            // 1. Assignment block
            AssignmentBlock assignBlock = new AssignmentBlock("x", "10");
            assignBlock.setDocument(document);
            RectangleBlockView assignView = new RectangleBlockView(assignBlock, document);
            mainPanel.add(assignView);

            // Connector
            ConnectorView connector1 = new ConnectorView(document, 30);
            mainPanel.add(connector1);

            // 2. Assignment block 2
            AssignmentBlock assignBlock2 = new AssignmentBlock("y", "x * 2");
            assignBlock2.setDocument(document);
            RectangleBlockView assignView2 = new RectangleBlockView(assignBlock2, document);
            mainPanel.add(assignView2);

            // Connector
            ConnectorView connector2 = new ConnectorView(document, 30);
            mainPanel.add(connector2);

            // 3. IF block (diamond)
            IfBlock ifBlock = new IfBlock("x > 5");
            ifBlock.setDocument(document);
            DiamondBlockView ifView = new DiamondBlockView(ifBlock, document);
            mainPanel.add(ifView);

            // Connector
            ConnectorView connector3 = new ConnectorView(document, 30);
            mainPanel.add(connector3);

            // 4. Input block (parallelogram)
            InputBlock inputBlock = new InputBlock("n");
            inputBlock.setDocument(document);
            ParallelogramBlockView inputView = new ParallelogramBlockView(inputBlock, document);
            mainPanel.add(inputView);

            // Connector
            ConnectorView connector4 = new ConnectorView(document, 30);
            mainPanel.add(connector4);

            // 5. Output block (parallelogram)
            OutputBlock outputBlock = new OutputBlock("x + y");
            outputBlock.setDocument(document);
            ParallelogramBlockView outputView = new ParallelogramBlockView(outputBlock, document);
            mainPanel.add(outputView);

            // Connector
            ConnectorView connector5 = new ConnectorView(document, 30);
            mainPanel.add(connector5);

            // 6. Comment block
            CommentBlock commentBlock = new CommentBlock("This is a test comment");
            commentBlock.setDocument(document);
            RectangleBlockView commentView = new RectangleBlockView(commentBlock, document);
            mainPanel.add(commentView);

            // Wrap in scroll pane
            JScrollPane scrollPane = new JScrollPane(mainPanel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            // Add to frame
            frame.add(scrollPane);

            // Add info panel
            JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            infoPanel.add(new JLabel("AlgoBuild Rendering Test - Blocchi con forme corrette!"));
            frame.add(infoPanel, BorderLayout.SOUTH);

            // Show frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            System.out.println("✓ AlgoBuild rendering test started");
            System.out.println("✓ Showing blocks: Assignment, IF (diamond), Input (parallelogram), Output (parallelogram), Comment");
            System.out.println("✓ Hover over blocks to see highlighting");
            System.out.println("✓ Hover over connectors (lines) to see 'NEW' button");
        });
    }
}
