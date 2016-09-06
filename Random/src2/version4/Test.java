package version4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ${LiuShuo} on 2016/9/6.
 */
public class Test {
    public static void main(String[] args) {
        /*Set<String> s = new HashSet<>();
        String[] ss = {"010","021","022","023","0311","0319","0311","0318","0319","0319","0310","0317","0317","0317","0315","0335","0312","0314","0312","0312","0316","0313","0351","0354","0350","0352","0357","0357","0359","0353","0355","0356","0471","0474","0479","0472","0478","0473","0477","0470","0470","0470","0476","0479","0482","0475","0475","0470","024","0419","0410","0410","0413","0412","0412","0417","0411","0411","0414","0415","0416","0429","0429","0421","0421","0418","0427","0411","0431","0438","0432","0432","0433","0433","0433","0433","0435","0435","0439","0448","0434","0436","0437","0434","0436","0439","0451","0450","0451","0455","0458","0454","0454","0453","0454","0454","0453","0453","0453","0452","0459","0456","0456","0456","025","0514","0511","0511","0519","0510","0510","0510","0512","0520","0516","0518","0517","0517","0527","0515","0515","0514","0523","0523","0513","0512","0571","0571","0575","0572","0573","0573","0574","0574","0580","0576","0576","0579","0579","0578","0570","0570","0577","0579","0579","0577","0551","0554","0552","0557.","0561","0558","0558","0564","0565","0550","0553","0563","0559","0555","0562","0559","0556",".0556","0591","0594","0599","0599","0592","0595","0595","0596","0597","0598","0598","0593","0791","0792","0798","0793","0701","0795","0790","0799","0797","0796","0796","0794","0794","0792","0531","0635","0635","0534","0533","0543","0546","0536","0536","0536","0535","0631","0532","0538","0634","0538","0537","0537","0530","0539","0633","0632","0632","0631","0371","0373","0391","0372","0392","0393","0374","0395","0396","0376","0394","0375","0379","0398","0398","0377","0378","0370","027","0713","0728","0712","0712","0712","0728","0728","0716","0728","0724","0716","0711","0714","0715","713","0715","0710","0710","0722","0719","0719","0717","0717","0718","0718","0891","0892","0983","0894","0895","0896","0897","0731","0732","0732","0733","0737","0730","0730","0736","0736","07481","0744","0738","0738","0738","0745","0745","0734","0734","0739","0735","0746","0746","020","0763","0769","0751","0753","0754","0768","0752","0660","0762","0755","0759","0668","0758","0757","0760","0750","0662","0771","0771","0776","0777","0779","0775","0773","0774","0772","0772","0778","0777","0898","0899","0899","0890","028","0837","0834","0833","0838","0812","0835","0816","0825","0839","0817","0818","0832","0826","0831","0813","0830","0851","0858","0856","0855","0854","0853","0859","0852","0852","0857","0951","0952","0953","0953","0954","0871","0881","0874","0870","0873","0873","0872","0878","0875","0877","0876","0879","0691","0692","0887","0886","0883","0888","029","0910","0911","0913","0912","0915","0914","0917","0916","0919","0931","0943","0930","0935","0936","0937","0937","0937","0935","0938","0933","0934","0971","0972","0973","0974","0975","0976","0977","0978","0979","0970","0991","0994","0993","0992","0990","0909","0995","0999","0906","0901","0996","0902","0997","0998","0908","0903"
        };
        String[] num2Line ={"0470","0431","0978","0979","0970","0991","0994","0993","0992","0990","0909","0995","0999","0906","0901","0996","0902","0997","0998","0908","0903","0910","0911","0913","0912","0915","0914","0917","0916","0919","0931","0943","0930","0935","0936","0937","0937","0937","0935","0938","0933","0934","0971","0972","0973","0974","0975","0976","0977","0872","0878","0875","0877","0876","0879","0691","0692","0887","0886","0883","0888","0817","0818","0832","0826","0831","0813","0830","0851","0858","0856","0855","0854","0853","0859","0852","0852","0857","0951","0952","0953","0953","0954","0871","0881","0874","0870","0873","0873","0750","0662","0771","0771","0776","0777","0779","0775","0773","0774","0772","0772","0778","0777","0898","0899","0899","0890","0837","0834","0833","0838","0812","0835","0816","0825","0839","0744","0738","0738","0738","0745","0745","0734","0734","0739","0735","0746","0746","0763","0769","0751","0753","0754","0768","0752","0660","0762","0755","0759","0668","0758","0757","0760","0718","0891","0892","0983","0894","0895","0896","0897","0731","0732","0732","0733","0737","0730","0730","0736","0736","0398","0377","0378","0370","0713","0728","0712","0712","0712","0728","0728","0716","0728","0724","0716","0711","0714","0715","0713","0715","0710","0710","0722","0719","0719","0717","0717","0718","0535","0631","0532","0538","0634","0538","0537","0537","0530","0539","0633","0632","0632","0631","0371","0373","0391","0372","0392","0393","0374","0395","0396","0376","0394","0375","0379","0398","0795","0790","0799","0797","0796","0796","0794","0794","0792","0531","0635","0635","0534","0533","0543","0546","0536","0536","0536","0556",".0556","0591","0594","0599","0599","0592","0595","0595","0596","0597","0598","0598","0593","0791","0792","0798","0793","0701","0579","0579","0577","0551","0554","0552","0557.","0561","0558","0558","0564","0565","0550","0553","0563","0559","0555","0562","0559","0513","0512","0571","0571","0575","0572","0573","0573","0574","0574","0580","0576","0576","0579","0579","0578","0570","0570","0577","0514","0511","0511","0519","0510","0510","0510","0512","0520","0516","0518","0517","0517","0527","0515","0515","0514","0523","0523","0451","0455","0458","0454","0454","0453","0454","0454","0453","0453","0453","0452","0459","0456","0456","0456","0438","0432","0432","0433","0433","0433","0433","0435","0435","0439","0448","0434","0436","0437","0434","0436","0439","0451","0450","0419","0410","0410","0413","0412","0412","0417","0411","0411","0414","0415","0416","0429","0429","0421","0421","0418","0427","0411","0470","0476","0479","0482","0475","0475","0470","0351","0354","0350","0352","0357","0357","0359","0353","0355","0356","0471","0474","0479","0472","0478","0473","0477","0470","0311","0319","0311","0318","0319","0319","0310","0317","0317","0317","0315","0335","0312","0314","0312","0312","0316","0313"
        };
        for (int i = 0; i <num2Line.length ; i++) {
            if (num2Line[i].length() == 3) System.out.println(num2Line[i]);
        }*/

//        String s = "123456789";
//        System.out.println(s.indexOf("2"));
        Object o = Temp.getModelTele("44105410",null);
        System.out.println(o);

    }
}
