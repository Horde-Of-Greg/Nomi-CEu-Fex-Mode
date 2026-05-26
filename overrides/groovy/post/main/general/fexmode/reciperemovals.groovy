package post.main.general.fexmode

//remove all converters
for (var converterId : (1670..1709)) {
    var convertersAll = item("gregtech:machine:${converter_id}")
    //mods.jei.ingredient.hide(metaname) comment cuz maybe i wanna add this
    crafting.removeByOutput([convertersAll])
}

//remove fine wire recipes for basic resistors
crafting.remove('gregtech:resistor_wire_fine')
crafting.remove('gregtech:resistor_wire_fine_charcoal')
crafting.remove('gregtech:resistor_wire_fine_carbon')
