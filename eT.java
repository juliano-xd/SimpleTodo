import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class eT {
    private static final File file = new File(".\\list");
    private static final String INCORRECT_SYNTAX = "Sintaxe incorreta";

    public static void main(String[] args) {
        int size = args.length;
        if (size == 0) return;

        LinkedList<String> lines = loadLines();

        String func = args[0];
        try {
            if (size == 1 && func.equals("-l")) {
                displayLines(lines);
            } else {
                boolean done = false;
                if (size == 2 && func.equals("-r") && args[1].matches("\\d+")) {
                    int position = Integer.parseInt(args[1]);
                    if (position >= 0 && position < lines.size()) {
                        lines.remove(position);
                        update(lines);
                        done = true;
                    }
                } else if (size > 2 && func.equals("-a")) {
                    String secFunc = args[1];
                    boolean isMessage = secFunc.equals("-m");
                    if (isMessage || (size > 3 && secFunc.matches("\\d+") && args[2].equals("-m"))) {
                        int position = isMessage ? lines.size() : Integer.parseInt(secFunc);
                        String[] message = isMessage ? Arrays.copyOfRange(args, 1, size) : Arrays.copyOfRange(args, 2, size);
                        lines.add(position, String.join(" ", message));
                        file.delete();
                        update(lines);
                        done = true;
                    }
                }
                update(lines);
                finale(done);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<String> loadLines() {
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            lines.addAll(reader.lines().collect(Collectors.toList()));
        } catch (Throwable error) {
            System.out.println("Erro no carregamento da lista:\n" + error);
        }
        return lines;
    }

    private static void update(List<String> lines) throws Throwable {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.join("\n", lines));
        }
    }

    private static void displayLines(List<String> lines) {
        System.out.println("--------coisas a fazer --------");
        lines.forEach(System.out::println);
        System.out.println("-------------------------------");
    }

    private static void finale(boolean done) {
        String message = done ? "Done!" : "Fail!\n" + INCORRECT_SYNTAX;
        System.out.println(message);
    }
}
