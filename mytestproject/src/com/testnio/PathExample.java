package com.testnio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dell on 2017/9/6.
 */
public class PathExample {
    public static void main(String[] args) {
//        绝对路径
//        Path txt = Paths.get("d:/mytestdata/path.txt");
//        相对路径
//        Path relPath = Paths.get("d:/mytestdata", "projects");
//        System.out.println(relPath.toAbsolutePath().toString());
//        .  当前路径  ..  上一层路径
//        Path  currentDir = Paths.get(".");
//        System.out.println(currentDir.toAbsolutePath().toString());

        Path middlePointDir = Paths.get("d:\\mytestdata\\projects\\.\\a-project");
        System.out.println(middlePointDir);
//        Path  currentDir = Paths.get(".");
//        System.out.println(currentDir.toAbsolutePath().toString());
//        Path parentDir = Paths.get("..");
//        System.out.println(parentDir.toAbsolutePath().toString());
//        String originalPath = "d:/data/projects/a-project/../another-project";
//        Path path1 = Paths.get(originalPath);
//        System.out.println("path1 " + path1);
//        Path path2 = path1.normalize();
//        System.out.println("path2 " + path2);
//        Path path = Paths.get("data");
//        System.out.println(path);


    }
}
