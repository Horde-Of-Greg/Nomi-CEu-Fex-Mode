package post.main.general.fexmode

//Diamond Hook diamonds -> plates
crafting.remove('hooked:diamond_hook')
crafting.shapedBuilder()
    .output(item('hooked:hook:2'))
    .matrix(
        ' PP',
        ' HP',
        'P  ')
    .key('H', item('hooked:hook:1'))
    .key('P', metaitem('plateDiamond'))
    .register()

//Vacuum Tube steel bolts -> steel rods
crafting.remove('gregtech:vacuum_tube')
crafting.shapedBuilder()
    .output(metaitem('circuit.vacuum_tube'))
    .matrix(
        '   ',
        'RGR',
        'WWW')
    .key('R', metaitem('stickSteel'))
    .key('G', metaitem('component.glass.tube'))
    .key('W', ore('wireGtSingleCopper'))
    .register()

//PBF changes
crafting.remove('gregtech:bronze_primitive_blast_furnace')
crafting.shapedBuilder()
    .output(metaitem('primitive_blast_furnace.bronze'))
    .matrix(
        'BPP',
        'WHP',
        'BPP')
    .key('B', item('gregtech:metal_casing:1')) //these are firebricks the metaitem name is fuhed or smn
    .key('P', metaitem('plateDoubleWroughtIron'))
    .key('W', ore('toolWrench'))
    .key('H', ore('blockCoke'))
    .register()

//cbt cupronickel coil
mods.gregtech.assembler.removeByInput(
  30,
  [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8],
  [fluid('tin_alloy') * 144]
)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('wireGtDoubleCupronickel') * 12, metaitem('foilBronze') * 12, metaitem('wireFineCopper') * 48)
    .fluidInputs(fluid('tin_alloy') * 288)
    .outputs(item('gregtech:wire_coil:0'))
    .duration(400).EUt(30)
    .buildAndRegister()

//lv energy hatch now requires 250mb of NaK
crafting.remove('gregtech:energy_hatch.lv')
mods.gregtech.assembler.removeByInput(
  30,
  [metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv')],
  null
)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv'))
    .fluidInputs(fluid('sodium_potassium') * 250)
    .outputs(metaitem('energy_hatch.input.lv'))
    .duration(200).EUt(30)
    .buildAndRegister()

//pyro oven changes
crafting.remove('nomiceu:pyrolyse_oven')
crafting.shapedBuilder()
    .output(metaitem('pyrolyse_oven'))
    .matrix(
        'ECW',
        'CHC',
        'EPL')
    .key('E', metaitem('electric.piston.lv'))
    .key('C', ore('circuitLv'))
    .key('W', ore('wireGtHexSteel'))
    .key('H', metaitem('hull.ulv'))
    .key('P', metaitem('electric.pump.lv'))
    .key('L', ore('pipeHugeFluidLead'))
    .register()

//pbf recipes changes
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyAsh')], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustAsh')], null)
mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'), metaitem('gemCoke') * 2)
    .outputs(metaitem('ingotSteel'))
    .duration(2400).EUt(1)
    .buildAndRegister()

//ebf steel changes
mods.gregtech.electric_blast_furnace.removeByInput(120, [item('minecraft:iron_ingot')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('ingotWroughtIron')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustWroughtIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustWroughtIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(ore('ingotIron'))
    .fluidInputs(fluid('oxygen') * 360)
    .outputs(metaitem('ingotSteel'))
    .property('temperature', 1800)
    .duration(120).EUt(480)
    .buildAndRegister()

//silicon boule buff
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustSilicon') * 32, metaitem('dustSmallGalliumArsenide'),
     metaitem('circuit.integrated').withNbt(['Configuration': 2])],
    null
)

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustSilicon') * 64, metaitem('dustGalliumArsenide'))
    .notConsumable(metaitem('circuit.integrated').withNbt(['Configuration': 3]))
    .fluidInputs(fluid('nitrogen') * 48000)
    .outputs(metaitem('boule.silicon'))
    .duration(47000).EUt(120)
    .property('temperature', 1784)
    .buildAndRegister()

//basic wafer cutting changes
mods.gregtech.cutter.removeByOutput([metaitem('wafer.silicon') * 16], null)
mods.gregtech.cutter.recipeBuilder()
    .inputs(metaitem('boule.silicon'))
    .fluidInputs(fluid('lubricant') * 200)
    .outputs(metaitem('wafer.silicon') * 16)
    .duration(1200).EUt(64)
    .buildAndRegister()

//lbb changes
crafting.remove('gregtech:large_bronze_boiler')
crafting.shapedBuilder()
    .output(metaitem('large_boiler.bronze'))
    .matrix(
        'WCW',
        'CHC',
        'WCW')
    .key('W', metaitem('cableGtOctalAnnealedCopper'))
    .key('C', ore('circuitLv'))
    .key('H', item('gregtech:turbine_casing:0')) //bronze gearbox
    .register()

//maintenance hatch changes
crafting.remove('gregtech:maintenance_hatch')
mods.gregtech.assembler.removeByInput(
    30,
    [metaitem('hull.lv'), metaitem('circuit.integrated').withNbt(['Configuration': 8])],
    null
)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('plateIron') * 2, metaitem('plateLead') * 2, metaitem ('ringRubber'))
    .notConsumable(metaitem('circuit.integrated').withNbt(['Configuration': 8]))
    .outputs(metaitem('maintenance_hatch'))
    .duration(200).EUt(30)
    .buildAndRegister()

//circuit assembler changes
crafting.remove('gregtech:gregtech.machine.circuit_assembler.lv')
crafting.shapedBuilder()
    .output(metaitem('circuit_assembler.lv'))
    .matrix(
        'APE',
        'CHC',
        'MFM')
    .key('A', metaitem('robot.arm.lv'))
    .key('P', metaitem('pipeNormalFluidLead'))
    .key('E', metaitem('emitter.lv'))
    .key('C', metaitem('conveyor.module.lv'))
    .key('H', metaitem('hull.lv'))
    .key('M', ore('circuitMv'))
    .key('F', metaitem('field.generator.lv'))
    .register()
