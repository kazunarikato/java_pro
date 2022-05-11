import java.util.*;
import java.io.*;

public class MergeSortTest {
    public static final int inputLimit = 10000;

    public static void main(String[] args) {
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            inputArrayListFromFile(args[0], arrayList);

            MergeSort.sort(arrayList);

            outputArrayListToConsole(arrayList);
        } catch(InputMismatchException ex) {
            System.out.println("ファイルに整数以外の入力が与えられました");
        } catch(FileNotFoundException ex) {
            System.out.println("入力されたファイルは存在しません．");
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) throws InputMismatchException, FileNotFoundException, IOException {
        File inputFile = new File(filename);
        Scanner sc = new Scanner(inputFile);
        while(sc.hasNext()) {
            if(arrayList.size() >= inputLimit) {
                throw new IOException("入力サイズの制限値10000を超えました．");
            }
            arrayList.add(sc.nextInt());
        }
    }

    private static void outputArrayListToConsole(ArrayList<Integer> arrayList) {
        System.out.println("ソート結果:");
        for(int i=0; i<arrayList.size(); ++i) {
            System.out.print(String.format("%11d", arrayList.get(i)));
            if(i % 10 == 9 || i == arrayList.size()-1) {
                System.out.println();
            } else {
                System.out.print(' ');
            }
        }
    }
};
