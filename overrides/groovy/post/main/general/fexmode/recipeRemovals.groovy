package post.main.general.fexmode

import gregtech.api.metatileentity.multiblock.CleanroomType

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

for (var wireType : wireTypes) {
    var superconsSingle = item("nomilabs:wire_single:${wireType}")
    mods.gregtech.extruder.removeByOutput([superconsSingle * 2], null)
}

//remove t2 board crafting table recipe
crafting.remove('gregtech:good_circuit_board')

//remove faster silicon recipe
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSiliconDioxide') * 3, metaitem('dustCarbon') * 2], null)

//remove pe plastic board recipe
mods.gregtech.chemical_reactor.removeByInput(10,
    [metaitem('platePlastic'),
     metaitem('foilCopper') * 4],
    [fluid('sulfuric_acid') * 250 * 250])

//remove non lcr epoxy recipe
mods.gregtech.chemical_reactor.removeByInput(30,
    [metaitem('dustSodiumHydroxide') * 3],
    [fluid('epichlorohydrin') * 1000 * 1000,
     fluid('bisphenol_a') * 1000 * 1000])

//remove me hatches and busses in to out and vice versa
crafting.remove('gregtech:me_fluid_hatch_input_to_output')
crafting.remove('gregtech:me_fluid_hatch_output_to_input')
crafting.remove('gregtech:me_item_bus_input_to_output')
crafting.remove('gregtech:me_item_bus_output_to_input')

//remove circass tin recipes, nano adv smd and quantum normal smd, theres probably a WAY better method of doing ts but idk
// Microprocessor non soc
mods.gregtech.circuit_assembler.removeByInput(60,
    [metaitem('circuit_board.plastic'),
     metaitem('plate.central_processing_unit'),
     metaitem('component.resistor') * 2,
     metaitem('component.capacitor') * 2,
     metaitem('component.transistor') * 2,
     metaitem('wireFineCopper') * 2],
    [fluid('tin') * 144 * 144])
// Microprocessor soc
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.plastic'),
     metaitem('plate.system_on_chip'),
     metaitem('wireFineCopper') * 2,
     metaitem('boltTin') * 2],
    [fluid('tin') * 144 * 144])

// Integrated Processor soc, others are alr removed in recipeChange
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.plastic'),
     metaitem('plate.system_on_chip'),
     metaitem('wireFineRedAlloy') * 4,
     metaitem('boltAnnealedCopper') * 4],
    [fluid('tin') * 144 * 144])

// Nanoprocessor non soc
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.smd.resistor') * 8,
     metaitem('component.smd.capacitor') * 8,
     metaitem('component.smd.transistor') * 8,
     metaitem('wireFineElectrum') * 8],
    [fluid('tin') * 144 * 144])
// Nanoprocessor soc
mods.gregtech.circuit_assembler.removeByInput(9600,
    [metaitem('circuit_board.advanced'),
     metaitem('plate.advanced_system_on_chip'),
     metaitem('wireFineElectrum') * 4,
     metaitem('boltPlatinum') * 4],
    [fluid('tin') * 144 * 144])
// Nanoprocessor adv smd
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.advanced_smd.resistor') * 2,
     metaitem('component.advanced_smd.capacitor') * 2,
     metaitem('component.advanced_smd.transistor') * 2,
     metaitem('wireFineElectrum') * 8],
    [fluid('soldering_alloy') * 72 * 72])
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.advanced_smd.resistor') * 2,
     metaitem('component.advanced_smd.capacitor') * 2,
     metaitem('component.advanced_smd.transistor') * 2,
     metaitem('wireFineElectrum') * 8],
    [fluid('tin') * 144 * 144])
// Nanoprocessor Assembly
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('circuit.nano_processor') * 2,
     metaitem('component.smd.inductor') * 4,
     metaitem('component.smd.capacitor') * 8,
     metaitem('plate.random_access_memory') * 8,
     metaitem('wireFineElectrum') * 16],
    [fluid('tin') * 288 * 288])
// Nanoprocessor Assembly adv smd
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('circuit.nano_processor') * 2,
     metaitem('component.advanced_smd.inductor'),
     metaitem('component.advanced_smd.capacitor') * 2,
     metaitem('plate.random_access_memory') * 8,
     metaitem('wireFineElectrum') * 16],
    [fluid('soldering_alloy') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(600,
    [metaitem('circuit_board.advanced'),
     metaitem('circuit.nano_processor') * 2,
     metaitem('component.advanced_smd.inductor'),
     metaitem('component.advanced_smd.capacitor') * 2,
     metaitem('plate.random_access_memory') * 8,
     metaitem('wireFineElectrum') * 16],
    [fluid('tin') * 288 * 288])
// Nano Supercomputer
mods.gregtech.circuit_assembler.removeByOutput([metaitem('circuit.nano_computer')], null)
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.advanced'),
        metaitem('circuit.nano_assembly') * 2,
        metaitem('component.smd.diode') * 8,
        metaitem('plate.nor_memory_chip') * 4,
        metaitem('nomilabs:wireFineLumium') * 8,
        metaitem('wireFineTungstenSteel') * 16)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('circuit.nano_computer'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400).EUt(600)
    .buildAndRegister()
// Nanoprocessor Mainframe
mods.gregtech.circuit_assembler.removeByInput(1920,
    [metaitem('frameAluminium') * 2,
     metaitem('circuit.nano_computer') * 2,
     metaitem('component.smd.inductor') * 16,
     metaitem('component.smd.capacitor') * 32,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireGtSingleAnnealedCopper') * 32],
    [fluid('tin') * 576 * 576])
// Nanoprocessor Mainframe adv smd
mods.gregtech.circuit_assembler.removeByInput(1920,
    [metaitem('frameAluminium') * 2,
     metaitem('circuit.nano_computer') * 2,
     metaitem('component.advanced_smd.inductor') * 4,
     metaitem('component.advanced_smd.capacitor') * 8,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireGtSingleAnnealedCopper') * 32],
    [fluid('soldering_alloy') * 288 * 288])
mods.gregtech.circuit_assembler.removeByInput(1920,
    [metaitem('frameAluminium') * 2,
     metaitem('circuit.nano_computer') * 2,
     metaitem('component.advanced_smd.inductor') * 4,
     metaitem('component.advanced_smd.capacitor') * 8,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireGtSingleAnnealedCopper') * 32],
    [fluid('tin') * 576 * 576])

// Quantumprocessor
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('plate.qbit_central_processing_unit'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.advanced_smd.capacitor') * 3,
     metaitem('component.advanced_smd.transistor') * 3,
     metaitem('wireFinePlatinum') * 12],
    [fluid('tin') * 144 * 144])
// Quantumprocessor smd
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('plate.qbit_central_processing_unit'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.smd.capacitor') * 12,
     metaitem('component.smd.transistor') * 12,
     metaitem('wireFinePlatinum') * 12],
    [fluid('soldering_alloy') * 72 * 72])
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('plate.qbit_central_processing_unit'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.smd.capacitor') * 12,
     metaitem('component.smd.transistor') * 12,
     metaitem('wireFinePlatinum') * 12],
    [fluid('tin') * 144 * 144])
// Quantumprocessor soc
mods.gregtech.circuit_assembler.removeByInput(38400,
    [metaitem('circuit_board.extreme'),
     metaitem('plate.advanced_system_on_chip'),
     metaitem('wireFinePlatinum') * 12,
     metaitem('boltNiobiumTitanium') * 8],
    [fluid('tin') * 144 * 144])
// Quantumprocessor Assembly
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_processor') * 2,
     metaitem('component.advanced_smd.inductor') * 2,
     metaitem('component.advanced_smd.capacitor') * 4,
     metaitem('plate.random_access_memory') * 4,
     metaitem('wireFinePlatinum') * 16],
    [fluid('tin') * 288 * 288])
// Quantumprocessor Assembly smd
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_processor') * 2,
     metaitem('component.smd.inductor') * 8,
     metaitem('component.smd.capacitor') * 16,
     metaitem('plate.random_access_memory') * 4,
     metaitem('wireFinePlatinum') * 16],
    [fluid('soldering_alloy') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_processor') * 2,
     metaitem('component.smd.inductor') * 8,
     metaitem('component.smd.capacitor') * 16,
     metaitem('plate.random_access_memory') * 4,
     metaitem('wireFinePlatinum') * 16],
    [fluid('tin') * 288 * 288])
// Quantum Supercomputer
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_assembly') * 2,
     metaitem('component.advanced_smd.diode') * 2,
     metaitem('plate.nor_memory_chip') * 4,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireFinePlatinum') * 32],
    [fluid('tin') * 288 * 288])
// Quantum Supercomputer smd
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_assembly') * 2,
     metaitem('component.smd.diode') * 8,
     metaitem('plate.nor_memory_chip') * 4,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireFinePlatinum') * 32],
    [fluid('soldering_alloy') * 144 * 144])
mods.gregtech.circuit_assembler.removeByInput(2400,
    [metaitem('circuit_board.extreme'),
     metaitem('circuit.quantum_assembly') * 2,
     metaitem('component.smd.diode') * 8,
     metaitem('plate.nor_memory_chip') * 4,
     metaitem('plate.random_access_memory') * 16,
     metaitem('wireFinePlatinum') * 32],
    [fluid('tin') * 288 * 288])
// Quantumprocessor Mainframe
mods.gregtech.circuit_assembler.removeByInput(7680,
    [metaitem('frameHssg') * 2,
     metaitem('circuit.quantum_computer') * 2,
     metaitem('component.advanced_smd.inductor') * 6,
     metaitem('component.advanced_smd.capacitor') * 12,
     metaitem('plate.random_access_memory') * 24,
     metaitem('wireGtSingleAnnealedCopper') * 48],
    [fluid('tin') * 576 * 576])
// Quantumprocessor Mainframe smd
mods.gregtech.circuit_assembler.removeByInput(7680,
    [metaitem('frameHssg') * 2,
     metaitem('circuit.quantum_computer') * 2,
     metaitem('component.smd.inductor') * 24,
     metaitem('component.smd.capacitor') * 48,
     metaitem('plate.random_access_memory') * 24,
     metaitem('wireGtSingleAnnealedCopper') * 48],
    [fluid('soldering_alloy') * 288 * 288])
mods.gregtech.circuit_assembler.removeByInput(7680,
    [metaitem('frameHssg') * 2,
     metaitem('circuit.quantum_computer') * 2,
     metaitem('component.smd.inductor') * 24,
     metaitem('component.smd.capacitor') * 48,
     metaitem('plate.random_access_memory') * 24,
     metaitem('wireGtSingleAnnealedCopper') * 48],
    [fluid('tin') * 576 * 576])

// Crystal Processor
mods.gregtech.circuit_assembler.removeByInput(9600,
    [metaitem('circuit_board.elite'),
     metaitem('crystal.central_processing_unit'),
     metaitem('plate.nano_central_processing_unit') * 2,
     metaitem('component.advanced_smd.capacitor') * 6,
     metaitem('component.advanced_smd.transistor') * 6,
     metaitem('wireFineNiobiumTitanium') * 8],
    [fluid('tin') * 144 * 144])
// Crystal Processor soc
mods.gregtech.circuit_assembler.removeByInput(86000,
    [metaitem('circuit_board.elite'),
     metaitem('crystal.system_on_chip'),
     metaitem('wireFineNiobiumTitanium') * 8,
     metaitem('boltYttriumBariumCuprate') * 8],
    [fluid('tin') * 144 * 144])
// Crystal Processor Assembly
mods.gregtech.circuit_assembler.removeByInput(9600,
    [metaitem('circuit_board.elite'),
     metaitem('circuit.crystal_processor') * 2,
     metaitem('component.advanced_smd.inductor') * 4,
     metaitem('component.advanced_smd.capacitor') * 8,
     metaitem('plate.random_access_memory') * 24,
     metaitem('wireFineNiobiumTitanium') * 16],
    [fluid('tin') * 288 * 288])
// Crystal Supercomputer
mods.gregtech.circuit_assembler.removeByOutput([metaitem('circuit.crystal_computer')], null)
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.elite'),
        metaitem('circuit.crystal_assembly') * 2,
        metaitem('plate.random_access_memory') * 4,
        metaitem('plate.nor_memory_chip') * 32,
        metaitem('plate.nand_memory_chip') * 64,
        metaitem('nomilabs:wireFineEnderium') * 32)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .cleanroom(CleanroomType.CLEANROOM)
    .outputs(metaitem('circuit.crystal_computer'))
    .duration(400).EUt(9600)
    .buildAndRegister()

// Wetware Processor
mods.gregtech.circuit_assembler.removeByInput(38400,
    [metaitem('processor.neuro'),
     metaitem('crystal.central_processing_unit'),
     metaitem('plate.nano_central_processing_unit'),
     metaitem('component.advanced_smd.capacitor') * 8,
     metaitem('component.advanced_smd.transistor') * 8,
     metaitem('wireFineYttriumBariumCuprate') * 8],
    [fluid('tin') * 144 * 144])
// Wetware Processor soc
mods.gregtech.circuit_assembler.removeByInput(150000,
    [metaitem('processor.neuro'),
     metaitem('plate.highly_advanced_system_on_chip'),
     metaitem('wireFineYttriumBariumCuprate') * 8,
     metaitem('boltNaquadah') * 8],
    [fluid('tin') * 144 * 144])
// Wetware Assembly
mods.gregtech.circuit_assembler.removeByInput(38400,
    [metaitem('circuit_board.wetware'),
     metaitem('circuit.wetware_processor') * 2,
     metaitem('component.advanced_smd.inductor') * 6,
     metaitem('component.advanced_smd.capacitor') * 12,
     metaitem('plate.random_access_memory') * 24,
     metaitem('wireFineYttriumBariumCuprate') * 16],
    [fluid('tin') * 288 * 288])



