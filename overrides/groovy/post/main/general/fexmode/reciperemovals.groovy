package post.main.general.fexmode

//remove all converters
for (var converterId : (1670..1709)) {
    var convertersAll = item("gregtech:machine:${converterId}") //cro only renamed it once
    //mods.jei.ingredient.hide(metaname) comment cuz maybe i wanna add this
    crafting.removeByOutput([convertersAll])
}

//remove fine wire recipes for basic resistors
crafting.remove('gregtech:resistor_wire_fine')
crafting.remove('gregtech:resistor_wire_fine_charcoal')
crafting.remove('gregtech:resistor_wire_fine_carbon')

//remove iron recipes for lv motors
crafting.remove('gregtech:electric_motor_lv_iron')
mods.gregtech.assembler.removeByInput(
  30,
  [
    metaitem('cableGtSingleTin') * 2,
    metaitem('stickIron') * 2,
    metaitem('stickIronMagnetic'),
    metaitem('wireGtSingleCopper') * 4
  ],
  null
)

//remove wrought iron in pbf (wip cuz idk how to do it nicely)
