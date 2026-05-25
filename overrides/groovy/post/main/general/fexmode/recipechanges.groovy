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

