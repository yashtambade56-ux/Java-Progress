import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MovieWatchlistGUI {

    static ArrayList<String> movies = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Movie Watchlist Organizer");
        frame.setSize(550, 500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter Movie Name:");

        JTextField movieInput = new JTextField(20);

        JButton addButton = new JButton("Add Movie");
        JButton deleteButton = new JButton("Delete Movie");
        JButton showButton = new JButton("Show Movies");
        JButton sortButton = new JButton("Sort Movies");
        JButton hashButton = new JButton("HashSet");
        JButton treeButton = new JButton("TreeSet");

        JTextArea output = new JTextArea(15, 45);
        output.setEditable(false);

        addButton.addActionListener(e -> {
            String movie = movieInput.getText();

            if (!movie.isEmpty()) {
                movies.add(movie);
                movieInput.setText("");
                output.setText("Movie added: " + movie);
            }
        });

        deleteButton.addActionListener(e -> {
            String movie = movieInput.getText();

            if (movies.remove(movie)) {
                output.setText("Movie deleted: " + movie);
            } else {
                output.setText("Movie not found: " + movie);
            }

            movieInput.setText("");
        });

        showButton.addActionListener(e -> {
            output.setText("Movies:\n");

            for (String movie : movies) {
                output.append(movie + "\n");
            }
        });

        sortButton.addActionListener(e -> {
            Collections.sort(movies);

            output.setText("Sorted Movies:\n");

            for (String movie : movies) {
                output.append(movie + "\n");
            }
        });

        hashButton.addActionListener(e -> {
            HashSet<String> hashMovies = new HashSet<>(movies);

            output.setText("HashSet - No Duplicates:\n");

            for (String movie : hashMovies) {
                output.append(movie + "\n");
            }
        });

        treeButton.addActionListener(e -> {
            TreeSet<String> treeMovies = new TreeSet<>(movies);

            output.setText("TreeSet - Sorted & No Duplicates:\n");

            for (String movie : treeMovies) {
                output.append(movie + "\n");
            }
        });

        
        frame.add(label);
        frame.add(movieInput);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(showButton);
        frame.add(sortButton);
        frame.add(hashButton);
        frame.add(treeButton);
        frame.add(new JScrollPane(output));

        frame.setVisible(true);
    }
}