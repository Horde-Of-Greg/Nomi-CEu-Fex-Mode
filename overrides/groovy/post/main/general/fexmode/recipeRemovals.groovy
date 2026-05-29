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

//remove op combustion fuels
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('naphtha')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('light_fuel')])

//remove non gt superconductors
List<String> wireTypes = ['1', '10', '11', '12', '13', '14', '17', '18', '25', '28']
List<String> wireSizes = ['single', 'double', 'quadruple', 'octal', 'hex']

for (var wireType : wireTypes) {
    for (var wireSize : wireSizes) {
        var superconsAll = item("nomilabs:wire_${wireSize}:${wireType}")
        mods.jei.ingredient.removeAndHide(superconsAll)
        mods.gregtech.wiremill.removeByOutput([superconsAll], null)
    }
}

for (var wireType : wireTypes){
    var superconsSingle = item("nomilabs:wire_single:${wireType}")
    mods.gregtech.extruder.removeByOutput([superconsSingle * 2], null)
}

//remove t2 board crafting table recipe
crafting.remove('gregtech:good_circuit_board')

//remove faster silicon recipe
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSiliconDioxide') * 3, metaitem('dustCarbon') * 2], null)



