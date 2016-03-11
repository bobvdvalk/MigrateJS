FileManager = {

    /**
     * This method is used to retrieve an object of the FilemanagerHandler class used to perform managing functions on the file system.
     * @returns {FileManagerClass} FileManagerHandler object.
     */
    getFileManagerHandler: function() {
        var fileManagerClass = Java.type("nl.mawoo.migratejs.extend.filemanager.FilemanagerHandler");
        return new fileManagerClass();
    },

    getFileManager: function() {
        var fileManagerClass = Java.type("java.nio.file.Files");
        return fileManagerClass;
    },

    getPath: function(path) {
        var fileManagerClass = Java.type("java.nio.file.Paths");
        return fileManagerClass.get(path);
    },

    copyOptions : {
        REPLACE_EXISTING: Java.type("java.nio.file.StandardCopyOption").REPLACE_EXISTING,
        COPY_ATTRIBUTES: Java.type("java.nio.file.StandardCopyOption").COPY_ATTRIBUTES,
        ATOMIC_MOVE: Java.type("java.nio.file.StandardCopyOption").ATOMIC_MOVE
    }
}