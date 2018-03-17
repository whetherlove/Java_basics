package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 17/03/2018 8:05 AM
 */
public class FilesExample {

    //note: The java.nio.file.Files class works with java.nio.file.Path instances
    //The Java NIO Files class (java.nio.file.Files) provides several methods for
    //manipulating files in the file system. see the Files api to get all methods

    public static void main(String[] args) throws IOException {

        //Files.copy()
        //1. copy(InputStream in, Path target, CopyOption... options)
        //options - options specifying how the copy should be done
        //option can be ignored
        //ATOMIC_MOVE
        //Move the file as an atomic file system operation.
        //COPY_ATTRIBUTES
        //Copy attributes to the new file.
        //REPLACE_EXISTING
        //Replace an existing file if it exists.
        //2. copy(Path source, OutputStream out)
        //Copies all bytes from a file to an output stream.
        //3. copy(Path source, Path target, CopyOption... options)
        //e.g.
        Files.copy(Paths.get("nio-data.txt"),Paths.get("nio-data.copy.txt"),REPLACE_EXISTING);

        //exists(Path path, LinkOption... options)
        //The Files.exists() method checks if a given Path exists in the file system.
        //the only options available is LinkOption.NOFOLLOW_LINKS, which means that the
        //Files.exists() method should not follow symbolic links in the file system to
        //determine if the path exists. If ignored, the default option is to follow.
        //e.g.
        Path path = Paths.get("data/logging.properties");
        boolean pathExists =
                Files.exists(path,
                        new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});

        //createDirectories(Path dir,FileAttribute<?>... attrs)
        //Creates a directory by creating all nonexistent parent directories first.
        //e.g.
        Path path1 = Paths.get("data/subdir");
        try {
            Path newDir = Files.createDirectory(path1);
        } catch(FileAlreadyExistsException e){
            // the directory already exists.
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }

        //FileAttribute<?>... attrs
        //used to specify permissions. see also Class PosixFilePermissions
        //e.g.
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
        FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions
                .asFileAttribute(permissions);

        //move(Path source, Path target, CopyOption... options)
        //Move or rename a file to a target file.

        //delete(Path path)
        //Deletes a file.
        //deleteIfExists(Path path)
        //Deletes a file if it exists.


//
//        boolean methods()
//        isDirectory(Path path, LinkOption... options)
//        Tests whether a file is a directory.
//        static boolean	isExecutable(Path path)
//        Tests whether a file is executable.
//        static boolean	isHidden(Path path)
//        Tells whether or not a file is considered hidden.
//        static boolean	isReadable(Path path)
//        Tests whether a file is readable.
//        static boolean	isRegularFile(Path path, LinkOption... options)
//        Tests whether a file is a regular file with opaque content.
//        static boolean	isSameFile(Path path, Path path2)
//        Tests if two paths locate the same file.
//        static boolean	isSymbolicLink(Path path)
//        Tests whether a file is a symbolic link.
//        static boolean	isWritable(Path path)

    }
}
