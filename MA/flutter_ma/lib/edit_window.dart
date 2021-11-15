import 'package:flutter/material.dart';
import 'package:flutter_ma/ViewModel/viewmodel.dart';
import 'package:provider/provider.dart';

import 'domain/dish.dart';


class EditWindow extends StatefulWidget{
  int target;
  EditWindow(this.target);
  _EditWindow createState()=>_EditWindow(target);

}



class _EditWindow extends State<EditWindow>{


  String val_name="";
  String val_ingr="";
  String val_recipe="";
  int target;
  result_type ?selectedValue;
  dish ?Dish;
  bool up = false;
  _EditWindow(this.target);


  @override
  Widget build(BuildContext context) {

    Dish = Provider.of<ViewModel>(context).get_one(target);
    if (up==false) {
      up = true;
      selectedValue = Dish!.Results;
      val_name = Dish!.Name;
      val_ingr = Dish!.Ingredients;
      val_recipe = Dish!.Recipe;
    }
    return  Scaffold(
            appBar: AppBar(title: Text('Edit Food Item ${target}'),),
            body: Column(
              children: <Widget>[
                Row(
                  children: <Widget>[
                    Expanded(child: Image(image:  Dish!.Img.image,)),
                    Expanded(child: TextField(decoration: InputDecoration(hintText: Dish!.Name),onChanged: (text){val_name=text;},))
                  ],
                ),
                Expanded(child: TextField(decoration: InputDecoration(hintText: Dish!.Ingredients),maxLines: 20,onChanged: (text){val_ingr=text;},)),
                Expanded(child: TextField(decoration: InputDecoration(hintText: Dish!.Recipe),maxLines: 20,onChanged: (text){val_recipe=text;},)),

                DropdownButton(value: selectedValue, items: const [
                  DropdownMenuItem(child: Text("CATASTROPHE"),value: result_type.CATASTROPHE,),
                  DropdownMenuItem(child: Text("FAILURE"),value: result_type.FAILURE,),
                  DropdownMenuItem(child: Text("OK"),value: result_type.OK,),
                  DropdownMenuItem(child: Text("SUCCESS"),value: result_type.SUCCESS,),
                  DropdownMenuItem(child: Text("MAGNUM_OPUS"),value: result_type.MAGNUM_OPUS,),
                ],
                  onChanged: (value){
                    setState(() {
                      selectedValue = value as result_type;
                    }
                    );
                  },
                ),

                //MyDropDown(sel: selectedValue),
                Expanded(child: Align(alignment:Alignment.bottomCenter,child:SizedBox(height:40,width: double.infinity,child:ElevatedButton(onPressed: () {

                  if (val_recipe=="" || val_name=="" || val_ingr=="")
                  {
                    showDialog(context: context, builder: (ctx) => AlertDialog(
                      title: Text("Invalid!"),
                      content: Text("Please fill all the boxes!"),
                      actions: <Widget>[
                        TextButton(onPressed: ()
                        {
                          Navigator.of(ctx).pop();
                        }, child: Text("Aight"))
                      ],
                    ));
                  }
                  else {
                    Provider.of<ViewModel>(context, listen: false).update_id(
                        target, new dish(
                        target, val_name, val_ingr, val_recipe, selectedValue!,
                        Dish!.Img));
                    Navigator.pop(context);
                  }

                }, child:  Text('Update',style: TextStyle(color: Colors.black)),style: ElevatedButton.styleFrom(primary: Colors.red,padding: EdgeInsets.all(5.0))))))
              ],
            )
        );


  }
}






