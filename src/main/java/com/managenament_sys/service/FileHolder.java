package com.managenament_sys.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class FileHolder {


	    private File currentFile;

	    /**
	     * Sets the currently active workbook file. This should be called
	     * immediately after the user selects a file with FileChooser.
	     */
	    public void setCurrentFile(File file) {
	        this.currentFile = file;
	        if (file != null) {
	            System.out.println("Workbook state updated. Current file: " + file.getAbsolutePath());
	        } else {
	            System.out.println("Workbook state cleared.");
	        }
	    }

	    /**
	     * Gets the currently active workbook file.
	     * Throws an error if no file is loaded, preventing NullPointerExceptions.
	     * @return The current File object.
	     */
	    public File getCurrentFile() {
	        if (currentFile == null) {
	            throw new IllegalStateException("No workbook is currently open. Cannot perform operation.");
	        }
	        return currentFile;
	    }

	    /**
	     * A safe way to check if a file has been loaded.
	     */
	    public boolean isFileLoaded() {
	        return currentFile != null;
	    }
	}

