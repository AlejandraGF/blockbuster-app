package tec.bd.blockbuster.cli.category;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;

import java.util.Calendar;
import java.util.Date;

@CommandLine.Command(name = "catu", description = "Update Category")
public class UpdateCategoryCommand implements Runnable {
    @CommandLine.Parameters(index = "0",paramLabel = "<Category id>", description = "Category id")
    private long id;

    @CommandLine.Parameters(index = "1",paramLabel = "<New Category Name>", description = "New Category Name")
    private String newName;


    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.updateCategory(new Categoria(id,newName));

    }
}
