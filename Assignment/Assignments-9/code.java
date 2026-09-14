import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StudentRecordFileManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        File directory = new File("StudentRecords");
        File file = new File(directory, "records.txt");

        try {

            if (!directory.exists()) {

                boolean created = directory.mkdir();

                if (created) {
                    System.out.println("Directory created: "
                            + directory.getName());
                } else {
                    System.out.println("Failed to create directory.");
                }

            } else {
                System.out.println("Directory already exists.");
            }


            if (!file.exists()) {

                if (file.createNewFile()) {
                    System.out.println("File created: "
                            + file.getName());
                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error while creating directory or file: "
                            + e.getMessage()
            );

        }


        int choice;


        do {

            System.out.println(
                    "\n===== Student Record File Manager ====="
            );

            System.out.println("1. Create Records Directory");
            System.out.println("2. Create Record File");
            System.out.println("3. Write Student");
            System.out.println("4. Display File Information");
            System.out.println("5. Read File Content");
            System.out.println("6. Append New Record");
            System.out.println("7. Delete Record File");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

                case 1:

                    if (!directory.exists()) {

                        if (directory.mkdir()) {
                            System.out.println(
                                    "Directory created successfully."
                            );
                        } else {
                            System.out.println(
                                    "Failed to create directory."
                            );
                        }

                    } else {

                        System.out.println(
                                "Directory already exists."
                        );

                    }

                    break;


                case 2:

                    try {

                        if (!directory.exists()) {

                            directory.mkdir();

                        }


                        if (file.exists()) {

                            System.out.println(
                                    "File already exists."
                            );

                        } else {

                            if (file.createNewFile()) {

                                System.out.println(
                                        "File created successfully."
                                );

                            }

                        }

                    } catch (IOException e) {

                        System.out.println(
                                "Error creating file: "
                                        + e.getMessage()
                        );

                    }

                    break;

                case 3:

                    try {

                        if (!file.exists()) {

                            System.out.println(
                                    "File does not exist."
                            );

                            break;
                        }


                        System.out.print(
                                "Enter student record: "
                        );

                        String record = sc.nextLine();


                        FileOutputStream output =
                                new FileOutputStream(file, false);


                        output.write(
                                record.getBytes()
                        );


                        output.write(
                                System.lineSeparator()
                                        .getBytes()
                        );


                        output.close();


                        System.out.println(
                                "Record written successfully."
                        );


                    } catch (IOException e) {

                        System.out.println(
                                "Error writing file: "
                                        + e.getMessage()
                        );

                    }

                    break;

                case 4:

                    if (file.exists()) {

                        System.out.println(
                                "\n===== File Information ====="
                        );

                        System.out.println(
                                "Name       : "
                                        + file.getName()
                        );

                        System.out.println(
                                "Path       : "
                                        + file.getPath()
                        );

                        System.out.println(
                                "Absolute Path : "
                                        + file.getAbsolutePath()
                        );

                        System.out.println(
                                "Size       : "
                                        + file.length()
                                        + " bytes"
                        );

                        System.out.println(
                                "Is File    : "
                                        + file.isFile()
                        );

                        System.out.println(
                                "Is Directory : "
                                        + file.isDirectory()
                        );

                    } else {

                        System.out.println(
                                "File does not exist."
                        );

                    }

                    break;


                case 5:

                    if (!file.exists()) {

                        System.out.println(
                                "File does not exist."
                        );

                        break;

                    }


                    try {

                        FileInputStream input =
                                new FileInputStream(file);


                        System.out.println(
                                "\n===== File Content ====="
                        );


                        int data;


                        // Read byte by byte
                        while ((data = input.read()) != -1) {

                            System.out.print(
                                    (char) data
                            );

                        }


                        input.close();

                        System.out.println();

                    } catch (IOException e) {

                        System.out.println(
                                "Error reading file: "
                                        + e.getMessage()
                        );

                    }

                    break;


                case 6:

                    if (!file.exists()) {

                        System.out.println(
                                "File does not exist."
                        );

                        break;

                    }


                    try {

                        System.out.print(
                                "Enter new student record: "
                        );

                        String newRecord =
                                sc.nextLine();


                        FileOutputStream output =
                                new FileOutputStream(
                                        file,
                                        true
                                );


                        output.write(
                                newRecord.getBytes()
                        );


                        output.write(
                                System.lineSeparator()
                                        .getBytes()
                        );


                        output.close();


                        System.out.println(
                                "Record appended successfully."
                        );


                    } catch (IOException e) {

                        System.out.println(
                                "Error appending record: "
                                        + e.getMessage()
                        );

                    }

                    break;


                case 7:

                    if (file.exists()) {

                        if (file.delete()) {

                            System.out.println(
                                    "File deleted successfully."
                            );

                        } else {

                            System.out.println(
                                    "Unable to delete file."
                            );

                        }

                    } else {

                        System.out.println(
                                "File does not exist."
                        );

                    }

                    break;

                case 8:

                    System.out.println(
                            "Program terminated."
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );

            }


        } while (choice != 8);


        sc.close();

    }
}
