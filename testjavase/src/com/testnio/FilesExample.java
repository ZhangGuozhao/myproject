package com.testnio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by dell on 2017/9/6.
 */
public class FilesExample {
    public static void main(String[] args) {
        Path path = Paths.get("data/logging.properties");
        boolean isPathExist = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});

//createDirectory
        Path pathCreate = Paths.get("d:/mytestdata/data.bin");
        try {
//            Path newPath = Files.createDirectory(pathCreate);

        } catch (Exception e) {
            e.printStackTrace();
        }
// copy and move
        Path sourcePath =  Paths.get("d:/mytestdata/data.bin");
        Path destinationPath = Paths.get("d:/mytestdata/copy");
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
//    Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        delete a file or directory
        Path deletePath =  Paths.get("d:/mytestdata/data.txt");
        try {
//            Files.delete(deletePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

//Searching For Files :閫掑綊鏌ユ壘
        Path rootPath = Paths.get("d:/mytestdata/delete");
        System.out.println("rootPath -- " + rootPath );
        System.out.println("rootPathAbsolutePath -- " + rootPath.toAbsolutePath());


        String fileToFind = File.separator + "fff.txt";
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    System.out.println("pathString = " + fileString );
                    if (fileString.endsWith(fileToFind)){
                        System.out.println("File found at " + file.toAbsolutePath());
                        return FileVisitResult.CONTINUE;
                    }
                    return  FileVisitResult.CONTINUE;

                }

            }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }


//            delete Directories Recursively:  递归删除路径下的文件和路径，然后删除当前路径
        System.out.println("======删除功能分界线========");

        Path  deleteTxt= Paths.get("D:\\mytestdata\\delete\\d1\\d1.2");
        try {
           Files.walkFileTree(deleteTxt, new SimpleFileVisitor<Path>(){
               @Override
               public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                   Path deletePath =  file.toAbsolutePath().toAbsolutePath();
                   System.out.println("delete file " + file.toString());
                   Files.delete(file);
                   return  FileVisitResult.CONTINUE;
               }

               @Override
               public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                   Files.delete(dir);
                   System.out.println("delete dir: " + dir.toString());

                   return FileVisitResult.CONTINUE;
               }
           });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
