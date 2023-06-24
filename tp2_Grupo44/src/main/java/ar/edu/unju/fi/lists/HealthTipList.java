package ar.edu.unju.fi.lists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.HealthTip;

@Component
public class HealthTipList {

    // region Attributes
    private List<HealthTip> consejos;
    // endregion

    // region Constructors
    public HealthTipList() {

        this.consejos = new ArrayList<HealthTip>();

        this.consejos.add(
                new HealthTip(
                        "Cómo cuidar a nuestras mascotas",
                        "Tener una mascota en casa requiere de compromiso y responsabilidad por parte de toda la familia.",
                        LocalDate.of(2020, 4, 6),
                        "/images/healttips/consejo0.jpg",
                        (short) 0));

        this.consejos.add(
            new HealthTip(
                "Cuidado del ambiente y su higiene",
                "Al momento de tener una mascota es necesario que cuenten con un lugar seguro donde puedan estar " +
                "comodos y poder resguardarse de los diferentes cambios climáticos como ser el frio, el calor, entre " +
                "otros.\n" +
                "\nHay que saber cuidarlos, educarlos, mimarlos y brindarles tiempo de convivencia con nosotros o con " +
                "otros animales ya sean de su misma especie u otras especies.\n" +
                "Mantener el cuadro de vacunación y desparasitación de perros o gatos, mantenerlos limpios y libres " +
                "de pulgas y/o garrapatas.\n" +
                "\nMantener limpia el área donde se encuentre la mascota.",
                LocalDate.of(2022, 3, 7),
                "/images/healttips/consejo1.png",
                (short) 1));

        this.consejos.add(
            new HealthTip(
                "Alimentación",
                "\nDarles una alimentación diaria, que sea sano y balanceado." +
                "\nEs fundamental que siempre tengan agua fresca y limpia ya que esto les ayuda a mantenerse hidratados " +
                "y a afrontar las épocas de calor; mantener su plato limpio." +
                "\nEvitar que ingieran alimentos en mal estado; en caso de que no se sientan bien llevarlos con un " +
                "veterinario y evitar darles remedios caseros o de humanos.",
                LocalDate.of(2020, 6, 16),
                "/images/healttips/consejo2.jpg",
                (short) 2));

        this.consejos.add(
            new HealthTip(
                "Ejercicios",
                "\nLos perros y gatos necesitas necesitan ejercicio ya que esto les ayuda a desestrarse y gastar su " +
                "energía." +
                "\nNecesitan socializar con otros animales.",
                LocalDate.of(2023, 1, 23),
                "/images/healttips/consejo3.jpg",
                (short) 3));

    }
    // endregion

    // region Getters and Setters
    public List<HealthTip> getConsejos() {
        return consejos;
    }

    public void setConsejos(List<HealthTip> consejos) {
        this.consejos = consejos;
    }
    // endregion

}
