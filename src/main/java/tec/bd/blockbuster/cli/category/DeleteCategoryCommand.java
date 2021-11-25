package tec.bd.blockbuster.cli.category;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;

import java.util.List;

@CommandLine.Command(name = "catd", description = "Delete Category")
public class DeleteCategoryCommand implements Runnable {



    @CommandLine.Parameters(paramLabel = "<Category id>", description = "Id of category")
    private long id;

    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        blockbuster.removeCategory(id);

    }
}
