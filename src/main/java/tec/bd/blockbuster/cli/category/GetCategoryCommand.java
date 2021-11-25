package tec.bd.blockbuster.cli.category;

import picocli.CommandLine;
import tec.bd.blockbuster.ApplicationContext;
import tec.bd.blockbuster.Blockbuster;
import tec.bd.blockbuster.entity.Categoria;
import tec.bd.blockbuster.entity.Movie;

import java.util.List;

@CommandLine.Command(name = "catr", description = "Select Categories")
public class GetCategoryCommand implements Runnable {


    @Override
    public void run() {
        Blockbuster blockbuster = new ApplicationContext().getBlockbuster();
        List<Categoria> categorias= blockbuster.getAllCategories();


        System.out.println("Codigo \t\t Nombre");
        for (Categoria c : categorias) {
            System.out.println(c.getId() + "\t\t" + c.getNombre());
        }
    }
}
