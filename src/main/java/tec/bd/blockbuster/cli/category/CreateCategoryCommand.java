package tec.bd.blockbuster.cli.category;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Cliente;

@Command(name = "catc", description = "Create Categories")
public class CreateCategoryCommand implements Runnable {

    @Parameters(paramLabel = "<Category Name>", description = "Category Name")
    private String name;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.addNewCategory(new Categoria(name));

    }
}
